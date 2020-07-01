public class SLList<T>{

    /** Inner class IntNode used as the underlining data structure for the SLList */
    private class IntNode{
        /** Member variables */
        T item;
        IntNode next;

        /** Constructor for the IntNode */
        public IntNode(T i, IntNode n){
            item = i;
            next = n;
        }
    }

    /** Member variables */
    private int size;
    private IntNode sentinel;

    /** Constructor for the SLList */
    public SLList(){
        sentinel = new IntNode(null, null); // null is a garbage value.
        sentinel.next = sentinel;
    }

    /** Add Last method for the List using Iteration */
    public void addLast(T i){
        IntNode P = sentinel;
        while(P.next != sentinel)
            P = P.next;
        P.next = new IntNode(i, P.next);
        size++;
    }

    /** Add Last method Recursively */
    public void addLastRecursive(T i){
        size++;
        sentinel.next = addLastRecursiveHelper(sentinel.next, i);
    }

    /** Private helper method for the addLast Recursive */
    private IntNode addLastRecursiveHelper(IntNode node, T item){
        if(node == sentinel)
            return new IntNode(item, sentinel);
        return new IntNode(node.item, addLastRecursiveHelper(node.next, item));
    }

}