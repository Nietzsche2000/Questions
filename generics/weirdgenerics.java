public class weirdgenerics<T1> extends Object {

    public static class Node<T2> {
        public T2 item;
        public Node next;

        public Node(T2 item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node<String> tt = new Node<>("the", null);
        tt.next = new Node<Integer>(1, null);
    }
}

// and this works yet I told it to be a string??? but int is allowed
public class SLList<T1> extends Object {

    public static class Node<T2> {
        public T2 item;
        public Node<T2> next;

        public Node(T2 item, Node<T2> next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node<String> tt = new Node<>("the", null);
        tt.next = new Node(1, null);
    }
}
