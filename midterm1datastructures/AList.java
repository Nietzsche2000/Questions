public class AList<T1> extends Object {

    public int size;
    public T1[] items;
    public int nextFirst;
    public int nextLast;

    public AList() {
        super();
        this.size = 0;
        this.items = (T1[]) new Object[8];
        this.nextFirst = 4;
        this.nextLast = 5;
    }

    public AList(AList other) {
        super();
    }

    public void resize(int capacity) {
    }

    public void addFirst(T1 item) {
        if (this.size() == this.items.length) {
            this.resize(this.size() * 2);
        }
        this.items[this.nextFirst] = item;
        this.nextFirst = Math.floorMod(this.nextFirst - 1, this.items.length);
        this.size += 1;
    }

    public void addLast(T1 item) {
        if (this.size() == this.items.length) {
            this.resize(this.size() * 2);
        }
        this.items[this.nextLast] = item;
        this.nextLast = Math.floorMod(this.nextLast + 1, this.items.length);
        this.size += 1;
    }

    public int size() {
        return this.size;
    }

    public void printAList() {

    }

    public T1 removeFirst() {
        this
    }

    public T1 removeLast() {
        return null;
    }

    public T1 get(int index) {
        return null;
    }

    public double usageRatio() {
        return -1;
    }


}