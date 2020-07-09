public class IntList extends Object {
    /**
     * Member variables
     */
    private int item;
    private IntList next;

    /**
     * Constructor for the IntList class
     */
    public IntList(int i, IntList n) {
        super();
        item = i;
        next = n;
    }

    /**
     * Add Last method for the IntList
     */
    public void addLast(int i) {
        /** Iterative method */
        IntList p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntList(i, null);
    }

    /**
     * Add last method recursively
     */
    public void addLastRecursive(int i) {
        if (next == null) {
            next = new IntList(i, null);
        } else
            next.addLastRecursive(i);
    }

    /**
     * Get Last method
     */
    public int getLast() {
        if (next == null)
            return item;
        return next.getLast();
    }

    /**
     * Get Last method using Iteration
     */
    public int getLastIteration() {
        IntList P = this;
        while (P.next != null) {
            P = P.next;
        }
        return P.item;
    }

    /**
     * Static method for adding many items
     */
    public static IntList of(int... args) {
        IntList P = new IntList(args[0], null);
        IntList Q = P;
        for (int i = 1; i < args.length; i++) {
            P.next = new IntList(args[i], null);
            P = P.next;
        }
        return Q;
    }

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p;
            for (int i = 0; i < n; i += 1) {
                if (next == null) {
                    return;
                }
                next = next.next;
            }
            p.next = next.next;
            p = p.next;
            n++;
        }
    }

    public static void main(String[] args) {
        IntList A = IntList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntList B = IntList.of(9, 8, 7, 6, 5, 4, 3, 2, 1);
        A.skippify();
        B.skippify();

    }

}