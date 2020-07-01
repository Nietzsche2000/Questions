import java.util.Objects;

public class SLList<T> {

    /**
     * Inner class IntNode used as the underlining data structure for the SLList
     */
    private class IntNode {
        /**
         * Member variables
         */
        T item;
        IntNode next;

        /**
         * Constructor for the IntNode
         */
        public IntNode(T i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /**
     * Member variables
     */
    private int size;
    private IntNode sentinel;

    /**
     * Constructor for the SLList
     */
    public SLList() {
        sentinel = new IntNode(null, null); // null is a garbage value.
        sentinel.next = sentinel;
    }

    /**
     * Add Last method for the List using Iteration
     */
    public void addLast(T i) {
        IntNode P = sentinel;
        while (P.next != sentinel)
            P = P.next;
        P.next = new IntNode(i, P.next);
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
    private IntNode addLastRecursiveHelper(IntNode node, T item) {
        if (node == sentinel)
            return new IntNode(item, sentinel);
        return new IntNode(node.item, addLastRecursiveHelper(node.next, item));
    }

    /**
     * Add First method for SLList
     */
    public void addFirst(T i) {
        sentinel.next = new IntNode(i, sentinel.next);
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
        IntNode p = sentinel;
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
    private T getLastHelper(IntNode node) {
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
        IntNode P = sentinel;
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
    private T getRecursiveHelper(IntNode node, int index) {
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

    /** Reverse
     * Sort
     * Based on comparator delete.
     * get that returns an index
     * multiply number of items by their value.
     * remove Last
     * remove First
     * remove an index
     */

    /**
     * Reverse method for the SLList recursively
     */
    public void reverse() {
        sentinel = reverse(sentinel);
    }

    /**
     * Recursive reverse method helper
     */
    private IntNode reverse(IntNode node) {
        if (node.next == sentinel) {
            sentinel.next = node;
            return node;
        }
        IntNode temp = reverse(node.next);
        temp.next = node;
        return node;
    }

    /**
     * Reverse method for the SLList Iteratively
     */
    public void reverseIterative() {
        IntNode P = sentinel;
        while (P.next != sentinel) {
            P.next.next = P;
        }

    }


}