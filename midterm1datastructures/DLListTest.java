import org.junit.Test;

import static org.junit.Assert.*;

public class DLListTest {

    @Test
    public void addLast() {
        DLList<Integer> L = new DLList<>();
        int max = 1000000;
        for (int i = 0; i < max; i++)
            L.addLast(i);
    }

    @Test
    public void addFirst() {
        DLList<Integer> L = new DLList<>();
        int max = 2000000;
        for (int i = 0; i < max; i++)
            L.addFirst(i);

    }

    @Test
    public void getFirstTest() {
        DLList<Integer> L = new DLList<>();
        int max = 2000000;
        assertNull(L.getFirst());
        for (int i = 0; i < max; i++)
            L.addFirst(i);
        assertTrue(max - 1 == L.getFirst());
    }

    @Test
    public void getLastTest() {
        DLList<Integer> L = new DLList<>();
        assertNull(L.getLast());
        int max = 2000000;
        for (int i = 0; i < max; i++)
            L.addFirst(i);
        assertTrue(0 == L.getLast());
    }

    @Test
    public void removeFirstTest() {
        DLList<Integer> L = new DLList<>();
        int max = 2000000;
        assertNull(L.removeFirst());
        for (int i = 0; i < max; i++)
            L.addLast(i);
        for (int i = 0; i < max; i++)
            assertTrue(L.removeFirst() == i);

    }

    @Test
    public void removeLastTest() {
        DLList<Integer> L = new DLList<>();
        int max = 2000000;
        assertNull(L.removeLast());
        for (int i = 0; i < max; i++)
            L.addLast(i);
        for (int i = max - 1; i >= 0; i--)
            assertTrue(L.removeLast() == i);
    }

    @Test
    public void getTest() {
        DLList<Integer> L = new DLList<>();
        int max = 50;
        assertNull(L.get(0));
        for (int i = 0; i < max; i++)
            L.addLast(i);
        for (int i = 0; i < max; i++)
            assertTrue(L.get(i) == i);
    }

    @Test
    public void sizeTest() {
        int max = 1000000;
        DLList<Integer> L = new DLList<>();
        assertTrue(L.size() == 0);
        for (int i = 0; i < max; i++) {
            L.addLast(i);
            L.addFirst(i);
        }
        assertTrue(L.size() == max * 2);
    }

    @Test
    public void removeAtIterativeTest() {
        DLList<Integer> L = new DLList<>();
        int max = 10;
        assertNull(L.removeAtIterative(0));
        for (int i = 0; i < max; i++)
            L.addLast(i);
        assertTrue(L.removeAtIterative(0) == 0);
        assertTrue(L.removeAtIterative(1) == 2);
        assertTrue(L.removeAtIterative(3) == 5);
        assertTrue(L.removeAtIterative(3) == 6);
        assertTrue(L.size() == max - 4);
    }

    @Test
    public void removeAtRecursiveTest() {
        DLList<Integer> L = new DLList<>();
        int max = 10;
        assertNull(L.removeAtRecursive(0));
        for (int i = 0; i < max; i++)
            L.addLast(i);
        assertTrue(L.removeAtRecursive(0) == 0);
        assertTrue(L.removeAtRecursive(1) == 2);
        assertTrue(L.removeAtRecursive(3) == 5);
        assertTrue(L.size() == max - 3);
    }

    @Test
    public void findTest() {
        DLList<Integer> L = new DLList<>();
        int max = 50;
        assertTrue(L.find(0) == -1);
        for (int i = 0; i < max; i++)
            L.addLast(i);
        for (int i = 0; i < max; i++)
            assertTrue(L.find(i) == i);
    }

    @Test
    public void findRecursiveTest() {
        DLList<Integer> L = new DLList<>();
        int max = 50;
        assertTrue(L.findRecursive(0) == -1);
        for (int i = 0; i < max; i++)
            L.addLast(i);
        for (int i = 0; i < max; i++)
            assertTrue(L.findRecursive(i) == i);
    }

    @Test
    public void reverseTest() {
        DLList<Integer> L = new DLList<>();
        int max = 50;
        assertTrue(L.findRecursive(0) == -1);
        for (int i = 0; i < max; i++)
            L.addLast(i);
        L.reverse();
        L.reverse();
        for (int i = 0; i < max; i++)
            assertTrue(L.find(i) == i);
    }

    @Test
    public void duplicateTest() {
        DLList<Integer> L = new DLList<>();
        int max = 4;
        for (int i = 0; i < max; i++)
            L.addLast(i);
        L.duplicate();
    }

    @Test
    public void reverseTestM() {
        DLList<Integer> L = new DLList<>();
        int max = 5;
        //assertTrue(L.findRecursive(0) == -1);
        for (int i = 0; i < max; i++)
            L.addLast(i);
        L.reverseMT();
        L.reverseMT();
        for (int i = 0; i < max; i++)
            assertTrue(L.find(i) == i);
    }

    @Test
    public void reverseTestNoH() {
        DLList<Integer> L = new DLList<>();
        int max = 5;
        //assertTrue(L.findRecursive(0) == -1);
        for (int i = 0; i < max; i++)
            L.addLast(i);
        DLList<Integer> rev = L.reverseNoM();
        rev = rev.reverseNoM();
        L = rev;
        for (int i = 0; i < max; i++)
            assertTrue(L.find(i) == i);
    }

}
