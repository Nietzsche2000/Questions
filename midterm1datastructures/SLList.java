<<<<<<< HEAD
public class SLList<T> {

    /**
     * Inner class IntNode used as the underlining data structure for the SLList
     */
    private class Node {
        /**
         * Member variables
         */
        T item;
        Node next;

        /**
         * Constructor for the IntNode
         */
        public Node(T i, Node n) {
            item = i;
            next = n;
        }
    }

    /**
     * Member variables
     */
    private int size;
    private Node sentinel;

    /**
     * Constructor for the SLList
     */
    public SLList() {
        sentinel = new Node(null, null); // null is a garbage value.
        sentinel.next = sentinel;
    }

    /**
     * Add Last method for the List using Iteration
     */
    public void addLast(T i) {
        Node P = sentinel;
        while (P.next != sentinel)
            P = P.next;
        P.next = new Node(i, P.next);
        size++;
    }

    /**
     * Add Last method Recursively
     */
    public void addLastRecursive(T i) {
        size++;
        sentinel.next = addLastRecursiveHelper(sentinel.next, i);
    }

    /**
     * Private helper method for the addLast Recursive
     */
    private Node addLastRecursiveHelper(Node node, T item) {
        if (node == sentinel)
            return new Node(item, sentinel);
        return new Node(node.item, addLastRecursiveHelper(node.next, item));
    }

    /**
     * Add First method for SLList
     */
    public void addFirst(T i) {
        sentinel.next = new Node(i, sentinel.next);
        size++;
    }

    /**
     * Get First method
     */
    public T getFirst() {
        if (sentinel.next == sentinel)
            return null;
        return sentinel.next.item;
    }

    /**
     * Public get Last method Iteratively
     */
    public T getLast() {
        if (sentinel.next == sentinel)
            return null;
        Node p = sentinel;
        while (p.next != sentinel)
            p = p.next;
        return p.item;
    }

    /**
     * Public get Last method recursive
     */
    public T getLastRecursive() {
        if (sentinel.next == sentinel)
            return null;
        return getLastHelper(sentinel.next);
    }

    /**
     * Private method for getLast recursive
     */
    private T getLastHelper(Node node) {
        if (node.next == sentinel)
            return node.item;
        return getLastHelper(node.next);
    }

    /**
     * Get method at a particular index iteratively
     */
    public T get(int index) {
        if (index >= size || index < 0)
            return null;
        Node P = sentinel;
        while (index >= 0) {
            P = P.next;
            index--;
        }
        return P.item;
    }

    /**
     * Get method at a particular method recursively
     */
    public T getRecursive(int index) {
        if (index >= size || index < 0)
            return null;
        return getRecursiveHelper(sentinel.next, index);
    }

    /**
     * Private helper method for recursive get
     */
    private T getRecursiveHelper(Node node, int index) {
        if (index == 0)
            return node.item;
        return getRecursiveHelper(node.next, index - 1);
    }

    /**
     * Get size method
     */
    public int size() {
        return size;
    }

    /**
     * Sort
     * Based on comparator delete.
     * multiply number of items by their value.
     * /

    /**
     * Reverse method for the SLList recursively
     */
    public void reverse() {
        sentinel = reverse(sentinel);
    }

    /**
     * Recursive reverse method helper
     */
    private Node reverse(Node node) {
        if (node.next == sentinel) {
            sentinel.next = node;
            return node;
        }
        Node temp = reverse(node.next);
        temp.next = node;
        return node;
    }

    /**
     * Reverse method for the SLList Iteratively
     */
    public void reverseIterative() {
        Node P = sentinel.next;
        Node Q = sentinel;
        while (P != sentinel) {
            Node R = P.next;
            P.next = Q;
            Q = P;
            P = R;
            sentinel.next = Q;
        }
    }

    /**
     * Remove Last Method
     */
    public T removeLast() {
        if (sentinel.next == sentinel)
            return null;
        T lastItem;
        Node p = sentinel;
        while (p.next.next != sentinel) {
            p = p.next;
        }
        lastItem = p.next.item;
        p.next = sentinel;
        size--;
        return lastItem;
    }

    /**
     * Remove Last recursively
     */
    public T removeLastRecursive() {
        if (sentinel.next == sentinel)
            return null;
        size--;
        return removeLastRecursive(sentinel);
    }

    private T removeLastRecursive(Node node) {
        if (node.next.next == sentinel) {
            T item = node.next.item;
            node.next = node.next.next;
            return item;
        }
        return removeLastRecursive(node.next);

    }

    /**
     * Remove First
     */
    public T removeFirst() {
        if (sentinel.next == sentinel)
            return null;
        T item = getFirst();
        sentinel.next = sentinel.next.next;
        size--;
        return item;
    }

    /**
     * Remove on Index
     */
    public T removeAt(int index) {
        if (index >= size || index < 0)
            return null;
        Node P = sentinel;
        while (index > 0) {
            P = P.next;
            index--;
        }
        T item = P.next.item;
        P.next = P.next.next;
        size--;
        return item;
    }

    /**
     * Remove At recursive
     */
    public T removeAtRecursive(int index) {
        if (index >= size || index < 0)
            return null;
        size--;
        return removeAtRecursive(sentinel, index);
    }

    /**
     * Private Method for Remove At
     */
    private T removeAtRecursive(Node node, int index) {
        if (index == 0) {
            T item = node.next.item;
            node.next = node.next.next;
            return item;
        }
        return removeAtRecursive(node.next, index - 1);
    }

    /**
     * find method for SLList.
     * returns -1 if not in the list.
     */
    public int find(T item) {
        Node P = sentinel.next;
        int index = 0;
        while (P != sentinel) {
            if (P.item.equals(item))
                return index;
            P = P.next;
            index++;
        }
        return -1;
    }

    /**
     * Recursively find the index for a particular item
     * returns negative 1 if item not present
     */
    public int findRecursive(T item) {
        return findRecursive(sentinel.next, item);
    }

    /**
     * Private method for find Recursive
     */
    private int findRecursive(Node node, T item) {
        if (node == sentinel)
            return -1;
        if (item.equals(node.item))
            return 0;
        return 1 + findRecursive(node.next, item);
    }

    /*************************************************************
     * ***********************************************************
     * *******************PLAYGROUND FOR SLLIST*******************
     * ***********************************************************
     * ***********************************************************
     */
















=======
public class SLList<T1> extends Object {

    public static class Node<T2> extends Object {
        public T2 item;
        public Node next;

        public Node(T2 item, Node<T2> next) {
            super();
            this.item = item;
            this.next = next;
        }
    }

    public int size;
    public Node<T1> sentinel;

    public SLList() {
        super();
        this.sentinel = new Node<T1>(null, null);
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    public void addLast(T1 item) {
        Node<T1> pointerNode = this.sentinel;
        while (pointerNode.next != this.sentinel) {
            pointerNode = pointerNode.next;
        }
        pointerNode.next = new Node<T1>(item, this.sentinel);
        this.size += 1;
    }

    public void addLastRecursive(T1 item) {
        Node<T1> pointerNode = this.sentinel;
        this.addLastRecursiveHelper(item, pointerNode);
        this.size += 1;
    }

    public void addLastRecursiveHelper(T1 item, Node<T1> currentNode) {
        if (currentNode.next == this.sentinel) {
            currentNode.next = new Node<T1>(item, this.sentinel);
            return;
        }
        // When would I want to return this??? Ask Monish.
        //return this.addLastRecursiveHelper(item, currentNode.next);
        this.addLastRecursiveHelper(item, currentNode.next);
    }

    public void addFirst(T1 item) {
        Node<T1> pointerToLostNode = this.sentinel.next;
        this.sentinel.next = new Node<T1>(item, pointerToLostNode);
        size += 1;
    }

    public T1 getFirst() {
        if (this.sentinel.next == this.sentinel) {
            return null;
        }
        return (T1) this.sentinel.next.item;
    }

    public T1 getLast() {
        Node<T1> pointerNode = this.sentinel.next;
        if (this.sentinel.next == this.sentinel) {
            return null;
        }
        while (pointerNode.next != this.sentinel) {
            pointerNode = pointerNode.next;
        }
        return pointerNode.item;
    }

    public T1 get(int index) {
        Node<T1> realList = this.sentinel.next;
        if (realList == this.sentinel) {
            return null;
        }
        while (index != 0 && realList != this.sentinel) {
            realList = realList.next;
            index -= 1;
        }
        if (index == 0) {
            return realList.item;
        }
        return null;
    }

    public int listSize() {
        return this.size;
    }

    public T1 getRecursive(int index) {
        if (this.listSize() <= 0) {
            return null;
        }
        Node<T1> realList = this.sentinel.next;
        return this.getRecursiveHelper(index, realList);
    }

    public T1 getRecursiveHelper(int index, Node<T1> currentNode) {
        if (currentNode == this.sentinel) {
            return null;
        }
        else if (index == 0) {
            return currentNode.item;
        }
        return getRecursiveHelper(index-1, (Node<T1>) currentNode.next);

    }

    public T1 removeFirst() {
        if (this.sentinel.next == this.sentinel) {
            return null;
        }
        Node<T1> previousNode = this.sentinel.next;
        this.sentinel.next = this.sentinel.next.next;
        this.size -= 1;
        return previousNode.item;
    }

    public T1 removeLast() {
        Node<T1> currentNode = this.sentinel;
        if (this.sentinel.next == this.sentinel) {
            return null;
        }
        while (currentNode.next.next != this.sentinel) {
            currentNode = currentNode.next;
        }
        Node<T1> lostNode = currentNode.next;
        currentNode.next = this.sentinel;
        this.size -= 1;
        return lostNode.item;
    }

    public T1 removeAt(int index) {
        Node<T1> currentNode = this.sentinel;
        if (this.sentinel.next == this.sentinel) {
            return null;
        }
        this.size -= 1;
        return removeAtHelper(index, currentNode);
    }

    public T1 removeAtHelper(int index, Node<T1> currentNode) {
        if (index == 0) {
            Node<T1> lostNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            return lostNode.item;
        }
        return (T1) removeAtHelper(index - 1, currentNode.next);
    }

    public Integer find(T1 item) {
        int findIndex = 0;
        Node<T1> startNode = this.sentinel.next;
        if (this.listSize() == 0) {
            return null;
        }
        while (startNode != this.sentinel) {
            if (startNode.item == item) {
                return findIndex;
            }
            startNode = startNode.next;
            findIndex += 1;
        }
        return null;
    }


//    public static void main(String[] args) {
//        Node<String> tt = new Node<>("the", null);
//        tt.next = new Node<String>("dog", null);
//    }
>>>>>>> origin/ryan


}