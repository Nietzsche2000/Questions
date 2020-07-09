import org.junit.Test;

import static org.junit.Assert.*;

public class SLListTest {

    @Test
    public void addLast() {
        SLList<Integer> L = new SLList<>();
        for (int i = 0; i < 10; i++)
            L.addLastRecursive(i);
    }

    @Test
    public void getFirstTest() {
        SLList<Integer> L = new SLList<>();
        assertNull(L.getFirst());
        for (int i = 0; i < 10; i++)
            L.addLastRecursive(i);
        assertTrue(L.getFirst() == 0);
        L.addFirst(1);
        assertTrue(L.getFirst() == 1);
    }

    @Test
    public void getLastTest() {
        SLList<Integer> L = new SLList<>();
        assertNull(L.getLast());
        assertNull(L.getLastRecursive());
        for (int i = 0; i < 10; i++)
            L.addLastRecursive(i);
        assertTrue(L.getLast() == 9);
        assertTrue(L.getLastRecursive() == 9);
        L.addLast(1);
        assertTrue(L.getLast() == 1);
        assertTrue(L.getLastRecursive() == 1);
    }

    @Test
    public void getTest() {
        SLList<Integer> L = new SLList<>();
        assertNull(L.get(0));
        assertNull(L.getRecursive(0));
        for (int i = 0; i < 10; i++)
            L.addLastRecursive(i);
        for (int i = 0; i < 10; i++) {
            assertTrue(L.get(i) == i);
            assertTrue(L.getRecursive(i) == i);
        }
        assertNull(L.getRecursive(100000));
    }

    @Test
    public void sizeTest() {
        SLList<Integer> L = new SLList<>();
        assertTrue(L.size() == 0);
        for (int i = 0; i < 100; i++) {
            L.addFirst(i);
            L.addLastRecursive(i);
            L.addLast(i);
        }
        assertTrue(L.size() == 300);
    }

    @Test
    public void reverseTest() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        L.reverse();
        for (int i = 0; i < max; i++) {
            assertTrue(L.get(i) == (max - 1));
            max--;
        }
    }

    @Test
    public void reverseTestIterative() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        L.reverseIterative();
        for (int i = 0; i < max; i++) {
            assertTrue(L.get(i) == (max - 1));
            max--;
        }
    }

    @Test
    public void removeLastTest() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        assertNull(L.removeLast());
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        for (int i = max - 1; i >= 0; i--)
            assertTrue(L.removeLast() == i);
        assertTrue(L.size() == 0);
    }

    @Test
    public void removeLastRecursiveTest() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        assertNull(L.removeLastRecursive());
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        for (int i = max - 1; i >= 0; i--)
            assertTrue(L.removeLastRecursive() == i);
        assertTrue(L.size() == 0);
    }

    @Test
    public void removeFirstTest() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        assertNull(L.removeFirst());
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        for (int i = 0; i < max; i++)
            assertTrue(L.removeFirst() == i);
        assertTrue(L.size() == 0);
    }

    @Test
    public void removeAtTest() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        assertNull(L.removeAt(0));
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        assertTrue(L.removeAt(1) == 1);
        assertTrue(L.removeAt(2) == 3);
        assertTrue(L.removeAt(2) == 4);
        assertTrue(L.removeAt(0) == 0);
        assertTrue(L.size() == 1);
    }

    @Test
    public void removeAtRecursiveTest() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        assertNull(L.removeAtRecursive(0));
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        assertTrue(L.removeAtRecursive(1) == 1);
        assertTrue(L.removeAtRecursive(2) == 3);
        assertTrue(L.removeAtRecursive(2) == 4);
        assertTrue(L.removeAtRecursive(0) == 0);
        assertTrue(L.size() == 1);
    }

    @Test
    public void findTest() {
        int max = 10;
        SLList<Integer> L = new SLList<>();
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        assertTrue(L.find(5) == 5);
        assertTrue(L.find(6) == 6);
        assertTrue(L.find(7) == 7);
        assertTrue(L.find(8) == 8);
    }

    @Test
    public void findTestRecursive() {
        int max = 10;
        SLList<Integer> L = new SLList<>();
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        assertTrue(L.findRecursive(5) == 5);
        assertTrue(L.findRecursive(6) == 6);
        assertTrue(L.findRecursive(7) == 7);
        assertTrue(L.findRecursive(8) == 8);
    }
}
