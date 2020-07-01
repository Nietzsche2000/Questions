public class DLList<T> {

    /**
     * This DLList class uses Node class for its underlining data structure
     */
    private class Node {
        T item;
        Node next;
        Node prev;

        /**
         * Constructor for the Node class
         */
        public Node(T i, Node p, Node n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    /**
     * Member variables
     */
    private int size;
    private Node sentinel;

    /**
     * Constructor for the DLList Class
     */
    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Add Last method for the List.
     */
    public void addLast(T i) {
        Node prev = sentinel.prev;
        sentinel.prev = new Node(i, sentinel.prev, sentinel);
        prev.next = sentinel.prev;
        size++;
    }

    /**
     * Add First method for the List
     */
    public void addFirst(T i) {
        sentinel.next = new Node(i, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /**
     * Remove first method
     */
    public T removeFirst() {
        if (size == 0)
            return null;
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size--;
        return item;
    }

    /**
     * Remove Last method
     */
    public T removeLast() {
        if (size == 0)
            return null;
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return item;
    }

    /**
     * Get first method
     */
    public T getFirst() {
        if (size == 0)
            return null;
        return sentinel.next.item;
    }

    /**
     * Get Last Method
     */
    public T getLast() {
        if (size == 0)
            return null;
        return sentinel.prev.item;
    }

    /**
     * Get the value at a particular index
     */
    public T get(int index) {
        if (index >= size || index < 0)
            return null;
        int i = index;
        Node p;
        if (i > (size / 2)) {
            i = size - i - 1;
            p = sentinel.prev;
            while (i > 0) {
                p = p.prev;
                i--;
            }
        } else {
            p = sentinel.next;
            while (i > 0) {
                p = p.next;
                i--;
            }
        }
        return p.item;
    }

    /**
     * Size method for the DLList
     */
    public int size() {
        return size;
    }

    /**
     * Remove at a particular index iteratively
     */
    public T removeAtIterative(int index) {
        if (index >= size || index < 0)
            return null;
        int i = index;
        Node p;
        if (i > (size / 2)) {
            i = size - i - 1;
            p = sentinel.prev;
            while (i > 0) {
                p = p.prev;
                i--;
            }
        } else {
            p = sentinel.next;
            while (i > 0) {
                p = p.next;
                i--;
            }
        }
        T item = p.item;
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        return item;
    }

    /**
     * Remove at recursive
     */
    public T removeAtRecursive(int index) {
        if (index >= size || index < 0)
            return null;
        size--;
        return removeAtRecursive(sentinel.next, index);
    }

    /**
     * Private helper method for remove at Recursive
     */
    private T removeAtRecursive(Node node, int index) {
        if (index == 0) {
            T item = node.item;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return item;
        }
        return removeAtRecursive(node.next, index - 1);
    }

    /**
     * Find method: find the index of a particular item; returns -1 if not present
     */
    public int find(T item) {
        int i = 0;
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.item.equals(item))
                return i;
            p = p.next;
            i++;
        }
        return -1;
    }

    /** Find method recursive */
    public int findRecursive(T item){
        return findRecursive(sentinel.next, item);
    }

    /** Helper method for find recursive */
    private int findRecursive(Node node, T item){
        if(node == sentinel)
            return -1;
        if(node.item.equals(item))
            return 0;
        return 1 + findRecursive(node.next, item);
    }

    /** Reverse method */

}