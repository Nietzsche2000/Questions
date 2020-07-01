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


















}