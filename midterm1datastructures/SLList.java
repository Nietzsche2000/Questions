public class SLList<T1> extends Object {

    public static class Node<T2> {
        public T2 item;
        public Node next;

        public Node(T2 item, Node<T2> next) {
            this.item = item;
            this.next = next;
        }
    }



//    public static void main(String[] args) {
//        Node<String> tt = new Node<>("the", null);
//        tt.next = new Node<String>("dog", null);
//    }




}