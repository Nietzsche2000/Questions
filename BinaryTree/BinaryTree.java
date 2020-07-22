import java.util.ArrayList;

public class BinaryTree<T> {

    protected TreeNode root;

    public BinaryTree() {
        super();
        this.root = null;
    }

    public BinaryTree(TreeNode t) {
        super();
        this.root = t;
    }

    /**
     * This constructs a Binary Tree given the preorder traversal (pre) and inorder traversal (in) provided as ArrayList arguments.
     * We recommend a recursive approach.
     * @param pre A list of the preorder traversal of the tree.
     * @param in A list of the inorder traversal of the tree.
     */
    public BinaryTree(ArrayList<T> pre, ArrayList<T> in) {
    }

    /* Print the values in the tree in preorder. */
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printPreorder();
            System.out.println();
        }
    }

    /* Print the values in the tree in inorder. */
    public void printInorder() {
        //TODO: YOUR CODE HERE
        if (this.root == null) {
            return;
        }
        // this will call the print order on the root
        this.root.printInorder();
    }

    /* Prints the BinaryTree in preorder or in inorder. Used for your testing. */
    protected static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    protected class TreeNode {

        T item;
        TreeNode left;
        TreeNode right;
        int size = 0;

        public TreeNode(T item) {
            this.item = item; left = right = null;
        }

        public TreeNode(T item, TreeNode left, TreeNode right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        /* Prints the nodes of the BinaryTree in preorder. Used for your testing. */
        private void printPreorder() {
            System.out.print(item + " ");
            if (left != null) {
                left.printPreorder();
            }
            if (right != null) {
                right.printPreorder();
            }
        }

        /* Prints the nodes of the BinaryTree in inorder. Used for your testing. */
        private void printInorder() {
            //TODO: YOUR CODE HERE
            if (this.left != null) {
                this.left.printInorder();
            }
            System.out.print(this.item + " ");
            if (this.right != null) {
                this.right.printInorder();
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree();
        tree.root = tree.new TreeNode(2,
                    tree.new TreeNode(4,
                            tree.new TreeNode(5, null, null),
                            tree.new TreeNode(7, null, null)),
                    tree.new TreeNode(9, null, null));
        tree.printInorder();
    }
}