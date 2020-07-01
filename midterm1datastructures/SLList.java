public class SLList<T1> extends Object {

    public static class Node<T2> extends Object {
        public T2 item;
        public Node next;

        public Node(T2 item, Node<T2> next) {
            this.item = item;
            this.next = next;
        }
    }

    public int size;
    public Node<T1> sentinel;

    public SLList() {
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


}