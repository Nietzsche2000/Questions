public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    /* Creates an empty BST. */
    public BinarySearchTree() {
        // TODO: YOUR CODE HERE
        super();
    }

    /* Creates a BST with root as ROOT. */
    public BinarySearchTree(TreeNode root) {
        // TODO: YOUR CODE HERE
        super(root);
    }

    /* Returns true if the BST contains the given KEY. */
    public boolean contains(T key) {
        // TODO: YOUR CODE HERE
        TreeNode start = this.root;
        Boolean result = this.containsHelperFast(start, key);
        return result;
    }

    public boolean containsHelperSlow(TreeNode node, T key) {
        Boolean doesContain = false;
        if (node.item == key) {
            return true;
        }
        if (node.left != null) {
            doesContain |= this.containsHelperSlow(node.left, key);
        }
        if (node.right != null) {
            doesContain |= this.containsHelperSlow(node.right, key);
        }
        return doesContain;
    }

    public boolean containsHelperFast(TreeNode node, T key) {
        if (node == null) {
            return false;
        }
        // or could also have .equals
        if (node.item.compareTo(key) == 0) {
            return true;
        }
        // here I want to go left because the node is bigger then the key
        if (node.item.compareTo(key) > 0) {
            return this.containsHelperFast(node.left, key);
        }
        // otherwise I will go right
        return this.containsHelperFast(node.right, key);
    }

    /* Adds a node for KEY if KEY isn't in the BST already. */
    public void add(T key) {
        // TODO: YOUR CODE HERE
        TreeNode result = this.addHelperFast(this.root, key);
        this.root = result;

    }

    public TreeNode addHelperFast(TreeNode node, T key) {
        if (node == null) {
            return new TreeNode(key);
        }
        else if (node.item.compareTo(key) > 0) {
            node.left = this.addHelperFast(node.left, key);
        }
        else if (node.item.compareTo(key) < 0) {
            node.right = this.addHelperFast(node.right, key);
        }
        else if (node.item.compareTo(key) == 0) {
            return node;
        }
        return node;
    }

//    public T findKthLargestSlow(int k) {
//        if (k == 0) {
//            return null;
//        }
//        T answer = this.tt(this.root, k);
//        if (answer == null) {
//            System.out.println("Not in here.");
//        }
//        return answer;
//    }

//    public T findKthLargestSlowHelper(TreeNode node, int k, int i) {
//        if (k == i) {
//            return node.item;
//            if (i > k) {
//                return null;
//            }
//            T leftItem = findKthLargestSlowHelper(node.left, k, i + 1);
//            T otherItem = findKthLargestSlowHelper(node, k, i + 1);
//            T rightItem = findKthLargestSlowHelper(node.right, k, i + 1);
//        }
//        return null;
//    }

//    public T tt(TreeNode node, int k) {
//        if (k == 0) {
//            return node.item;
//        }
//        if (node.left != null) {
//            return this.tt(node.left, k - 1);
//        }
//        this.tt(node, k - 1);
//        if (node.right != null) {
//            return this.tt(node.right, k - 1);
//        }
//        return null;
//    }

    /* Deletes a node from the BST. 
     * Even though you do not have to implement delete, you 
     * should read through and understand the basic steps.
    */
    public T delete(T key) {
        TreeNode parent = null;
        TreeNode curr = root;
        TreeNode delNode = null;
        TreeNode replacement = null;
        boolean rightSide = false;

        while (curr != null && !curr.item.equals(key)) {
            if (((Comparable<T>) curr.item).compareTo(key) > 0) {
                parent = curr;
                curr = curr.left;
                rightSide = false;
            } else {
                parent = curr;
                curr = curr.right;
                rightSide = true;
            }
        }
        delNode = curr;
        if (curr == null) {
            return null;
        }

        if (delNode.right == null) {
            if (root == delNode) {
                root = root.left;
            } else {
                if (rightSide) {
                    parent.right = delNode.left;
                } else {
                    parent.left = delNode.left;
                }
            }
        } else {
            curr = delNode.right;
            replacement = curr.left;
            if (replacement == null) {
                replacement = curr;
            } else {
                while (replacement.left != null) {
                    curr = replacement;
                    replacement = replacement.left;
                }
                curr.left = replacement.right;
                replacement.right = delNode.right;
            }
            replacement.left = delNode.left;
            if (root == delNode) {
                root = replacement;
            } else {
                if (rightSide) {
                    parent.right = replacement;
                } else {
                    parent.left = replacement;
                }
            }
        }
        return delNode.item;
    }
}