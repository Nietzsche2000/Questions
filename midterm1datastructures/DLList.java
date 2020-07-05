<<<<<<< HEAD
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
        if (i >= (size / 2)) {
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

    /**
     * Find method recursive
     */
    public int findRecursive(T item) {
        return findRecursive(sentinel.next, item);
    }

    /**
     * Helper method for find recursive
     */
    private int findRecursive(Node node, T item) {
        if (node == sentinel)
            return -1;
        if (node.item.equals(item))
            return 0;
        return 1 + findRecursive(node.next, item);
    }

    /**
     * Reverse method using recursion
     */
    public void reverse() {
        sentinel = reverse(sentinel);
    }

    /**
     * Helper method for reverse
     */
    private Node reverse(Node node) {
        if (node.next == sentinel) {
            node.prev = sentinel;
            sentinel.next = node;
            return node;
        }
        Node reverseRest = reverse(node.next);
        reverseRest.next = node;
        node.prev = reverseRest;
        return node;
    }

    /** Destructive doubling of list */
    public void duplicate(){
        Node p = sentinel.next;
        while(p != sentinel){
            Node copy = new Node(p.item, p, p.next);
            p.next = copy;
            copy.next.prev = copy;
            p = p.next.next;
        }
        size *= 2;
    }

    /** Reverse without mutation */
    public void reverseMT(){
        if(size == 0)
            return;
        T item = removeFirst();
        reverseNoM();
        addLast(item);
    }

    /** Reverse return with no helper */
    public DLList<T> reverseNoM(){
        if(size == 0)
            return new DLList<>();
        T item  = removeLast();
        DLList<T> nL = reverseNoM();
        nL.addFirst(item);
        addLast(item);
        return nL;
    }

    /** Expand by number */
    public void expand(){
        Node p = sentinel.next;
        while (p != sentinel){
            T item2 = p.item;
            int item = (int) p.item;
            for(int i = 0; i < item - 1; i++){
                Node N = new Node(item2, p, p.next);
                N.prev.next = N;
                N.next.prev = N;
                p = p.next;
            }
            p = p.next;
        }
=======
public class DLList<T1> extends Object {

    public static class Node<T2> extends Object {

        public T2 item;
        public Node<T2> prev;
        public Node<T2> next;

        public Node() {
            super();
            this.item = null;
            this.prev = null;
            this.next = null;
        }

        public Node(T2 item, Node<T2> prev, Node<T2> next) {
            super();
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public Node<T1> sentinel;
    public int size;

    public DLList() {
        super();
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

//    public void addLast(T1 item) {
//        Node<T1> startNode = this.sentinel.next;
//        while (startNode.next != this.sentinel) {
//            startNode = startNode.next;
//        }
//        startNode.next = new Node<T1>(item, startNode, this.sentinel);
//        this.sentinel.prev = startNode.next;
//        this.size += 1;
//    }

    public void addLast(T1 item) {
        Node<T1> endNode = this.sentinel.prev;
        endNode.next = new Node<T1>(item, endNode, this.sentinel);
        this.sentinel.prev = endNode.next;
        this.size += 1;
    }

    public void addFirst(T1 item) {
        Node<T1> firstNode = this.sentinel.next;
        this.sentinel.next = new Node<T1>(item, this.sentinel, this.sentinel.next);
        firstNode.prev = this.sentinel.next;
        this.size += 1;
    }

    public T1 removeLast() {
        if (this.sentinel.next == this.sentinel) {
            return null;
        }
        Node<T1> originalLastNode = this.sentinel.prev;
        Node<T1> newLastNode = this.sentinel.prev.prev;
        newLastNode.next = this.sentinel;
        this.sentinel.prev = newLastNode;
        this.size -= 1;
        return originalLastNode.item;
    }

    public T1 removeFirst() {
        if (this.sentinel.next == this.sentinel) {
            return null;
        }
        Node<T1> originalFirstNode = this.sentinel.next;
        Node<T1> newFirstNode = this.sentinel.next.next;
        this.sentinel.next = this.sentinel.next.next;
        newFirstNode.prev = this.sentinel;
        this.size -= 1;
        return originalFirstNode.item;
    }

    public T1 removeAt(int index) {
        Node<T1> startNode = this.sentinel;
        if (this.listSize() <= index || index < 0 || this.listSize() == 0) {
            return null;
        }
        while (index != 0) {
            startNode = startNode.next;
            index -= 1;
        }
        Node<T1> lostNode = startNode.next;
        startNode.next.next.prev = startNode;
        startNode.next = startNode.next.next;
        this.size -= 1;
        return  lostNode.item;
    }

    public T1 removeAtFast(int index) {
        int currentIndex = -1;
        Node currentNode = this.sentinel;
        T1 removedItem = null;
        int decisionPoint = this.listSize() / 2;
        if (index >= this.listSize() || index < 0) {
            return null;
        }
        // then I want to use the prev
        else if (index >= decisionPoint) {
            currentIndex = this.listSize() - 1;
            while (currentIndex != index) {
                currentNode = currentNode.prev;
                currentIndex -= 1;
            }
            removedItem = (T1) currentNode.prev.item;
            currentNode.prev.prev.next = currentNode;
            currentNode.prev = currentNode.prev.prev;
            this.size -= 1;
            return removedItem;
        }
        // then I want to use the next
        else {
            currentIndex = 0;
            while (currentIndex != index) {
                currentNode = currentNode.next;
                currentIndex += 1;
            }
            removedItem = (T1) currentNode.next.item;
            currentNode.next.next.prev = currentNode;
            currentNode.next = currentNode.next.next;
            this.size -= 1;
            return removedItem;
        }
    }

    public int listSize() {
        return this.size;
    }

    public Integer find(T1 item) {
        Node<T1> pointerNode = this.sentinel.next;
        int indexTracker = 0;
        if (this.listSize() == 0) {
            return null;
        }
        while (pointerNode != this.sentinel) {
            if (pointerNode.item == item) {
                return indexTracker;
            }
            indexTracker += 1;
            pointerNode = pointerNode.next;
        }
        return null;
    }

    public T1 getFirst() {
        if (this.listSize() == 0) {
            return null;
        }
        return this.sentinel.next.item;
    }

    public T1 getLast() {
        if (this.listSize() == 0) {
            return null;
        }
        return this.sentinel.prev.item;
    }

    public T1 get(int index) {
        int currentIndex = -1;
        Node currentNode = this.sentinel;
        if (index >= this.listSize() || index < 0) {
            return null;
        }
        // here I want to scale the back end
        else if (index >= (this.listSize() / 2)) {
            currentIndex = this.listSize();
            while (currentIndex != index) {
                currentNode = currentNode.prev;
                currentIndex -= 1;
            }
            return (T1) currentNode.item;
        }
        // here I want to scale to the front
        else {
            currentIndex = -1;
            while (currentIndex != index) {
                currentNode = currentNode.next;
                currentIndex += 1;
            }
            return (T1) currentNode.item;
        }
    }
    // returns a non mutated copy of reversed dllist
    public DLList<T1> reverse() {
        DLList<T1> dlCopy = new DLList<>();
        this.reverseHelper(this.sentinel.next, dlCopy);
        return dlCopy;
    }

    private DLList<T1> reverseHelper(Node<T1> startNode, DLList<T1> dl) {
        if (startNode == this.sentinel) {
            return dl;
        }
        dl.addFirst(startNode.item);
        return reverseHelper(startNode.next, dl);
>>>>>>> origin/ryan
    }

}