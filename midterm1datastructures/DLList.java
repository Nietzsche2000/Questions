public class DLList<T1> extends Object {

    public static class Node<T2> extends Object {

        public T2 item;
        public Node<T2> prev;
        public Node<T2> next;

        public Node() {
            this.item = null;
            this.prev = null;
            this.next = null;
        }

        public Node(T2 item, Node<T2> prev, Node<T2> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public Node<T1> sentinel;
    public int size;

    public DLList() {
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
    }

}