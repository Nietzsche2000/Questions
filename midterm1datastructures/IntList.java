<<<<<<< HEAD
public class IntList extends Object{
    /** Member variables */
    private int item;
    private IntList next;

    /** Constructor for the IntList class */
    public IntList(int i, IntList n){
        super();
        item = i;
        next = n;
    }

    /** Add Last method for the IntList */
    public void addLast(int i){
        /** Iterative method */
        IntList p = this;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntList(i, null);
    }

    /** Add last method recursively */
    public void addLastRecursive(int i){
        if(next == null) {
            next = new IntList(i, null);
        }
        else
            next.addLastRecursive(i);
    }

    /** Get Last method */
    public int getLast(){
        if(next == null)
            return item;
        return next.getLast();
    }

    /** Get Last method using Iteration */
    public int getLastIteration(){
        IntList P = this;
        while(P.next != null){
            P = P.next;
        }
        return P.item;
    }

    /** Static method for adding many items */
    public static IntList of(int ...args){
        IntList P = new IntList(args[0], null);
        for(int i = 1; i < args.length; i++){
            P.next = new IntList(args[i], null);
            P = P.next;
        }
        return P;
    }

=======
/**
 * This class is a data structure similar to that of a normal linked list with the end being null.
 */
public class IntList extends Object {

    private int item;
    private IntList next;

    /**
     * This is a two argument constructor that makes an IntList with an item of item and a next of next.
     * @param item This is the value contained in the list at this position.
     * @param next This refers to the next IntList construct.
     */
    public IntList(int item, IntList next) {
        super();
        this.item = item;
        this.next = next;
    }

    /**
     * This is a zero argument constructor that makes an IntList with an item of 1 and a next of null.
     */
    public IntList() {
        super();
        this.item = 1;
        this.next = null;
    }

    /**
     * This method adds items to the end of the list.
     * @param value This method takes in a int and adds it as the last item in an IntList.
     */
    public void addLast(int value) {
        IntList integerList = this;
        while (integerList.next != null) {
            integerList = integerList.next;
        }
        integerList.next = new IntList(value, null);
    }

    /**
     * This method adds items to the end of the list.
     * @param value This method takes in a int and adds it as the last item in an IntList.
     */
    public void addLastRecursive(int value) {
        IntList integerList = this;
        if (integerList.next == null) {
            integerList.next = new IntList(value, null);
            return;
        }
        else {
            integerList.next.addLastRecursive(value);
        }
    }

//    /**
//     *
//     * @return This method returns the last item then removes it.
//     * @throws Exception When the index is not contained within the IntList.
//     */
//    public int removeLast() throws Exception {
//        if (this == null) {
//            throw new Exception();
//        }
//        else if (this.next == null) {
//            int returnValue = this.item;
//            this.item = -1;
//            return returnValue;
//        }
//        else if (this.next.next == null) {
//            int returnItem = this.next.item;
//            this.next = null;
//            return returnItem;
//        }
//        else {
//            return this.next.removeLast();
//        }
//    }

    /**
     * This is a get method, that gets the last item.
     * @return This method returns the last item from an IntList (iteration).
     */
    public int getLast() {
        IntList integerList = this;
        while (integerList.next != null) {
            integerList = integerList.next;
        }
        return integerList.item;
    }

    /**
     * This is a get method, that gets the last item.
     * @return This method returns the last item from an IntList (recursive).
     */
    public int getLastRecursive() {
        if (this.next == null) {
            return this.item;
        }
        else {
            return this.next.getLast();
        }
    }

    public static IntList of(int ...args) {
        IntList newNode = new IntList(args[0], null);
        IntList returnList = newNode;
        for (int index = 1; index < args.length; index++) {
            newNode.next = new IntList(args[index], null);
            newNode = newNode.next;
        }
        return returnList;
    }


>>>>>>> origin/ryan
}