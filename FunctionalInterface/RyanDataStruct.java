import java.util.Iterator;
import java.util.NoSuchElementException;

public class RyanDataStruct<T> implements Iterable<T> {

    public class Data {
        T item;
        Data next;

        public Data(T item, Data next) {
            this.item = item;
            this.next = next;
        }
    }

    private Data sentinel;
    private int size;

    public RyanDataStruct() {
        sentinel = new Data(null, null);
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new Data(item, sentinel.next);
        size++;
    }

    public Iterator<T> iterator() {
        return new RyanIterator();
    }

    private class RyanIterator implements Iterator<T> {

        int index = 0;
        Data ptr = sentinel;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (index >= size || ptr == null)
                throw new NoSuchElementException("Extension beyond scope");
            index++;
            Data t = ptr.next;
            ptr = ptr.next;
            return t.item;
        }
    }

    public static void main(String[] args) {
        RyanDataStruct<String> D = new RyanDataStruct<>();
        for (int i = 0; i < 3; i++) {
            D.addFirst(i + "hello");
        }

        for (String i : D) {
            System.out.println(i);
        }
    }
}
