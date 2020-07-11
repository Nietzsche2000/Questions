
import org.junit.Test;
import static org.junit.Assert.*;

public class SLListTest extends Object {
    /**
     * This test confirms that the sentinel and the structure of an SLList is circular.
     */
    @Test
    public void Test01() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.sentinel.item == null);
        assertTrue(sl.sentinel.next == sl.sentinel);
        assertTrue(sl.size == 0);
        assertTrue(sl.sentinel.next == sl.sentinel);
        SLList.Node<Integer> nextNode = sl.sentinel;
        for (int start = 0; start < repeatSize; start++) {
            assertTrue(nextNode.next == sl.sentinel);
            nextNode = nextNode.next;
        }
    }

    /**
     * This test confirms that the SLList is adjusting its size properly when addLast is called.
     */
    @Test
    public void Test02() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
        }
    }

    /**
     * This test confirms that the SLList is adjusting its size properly when addLastRecursive is called.
     */
    @Test
    public void Test03() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLastRecursive(start);
            assertTrue(sl.size == start);
        }
    }

    /**
     * This test confirms that addLast and getLast both work as intended.
     */
    @Test
    public void Test04() {
        int repeatSize = 1000;
        SLList<String> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start + "start");
            assertTrue(sl.size == start);
            assertTrue((sl.getLast()).equals(start + "start"));
        }
    }

    /**
     * This test confirms that addLast and getFirst both works as intended.
     */
    @Test
    public void Test05() {
        int repeatSize = 1000;
        SLList<String> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start + "start");
            assertTrue(sl.size == start);
            assertTrue((sl.getFirst()).equals("1start"));
        }
    }

    /**
     * This test confirms that addFirst and getFirst both work as intended.
     */
    @Test
    public void Test06() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addFirst(start);
            assertTrue(sl.size == start);
            assertTrue((sl.getFirst()).equals(start));
        }
    }

    /**
     * This test checks the get method to confirm that it behaves correctly.
     */
    @Test
    public void Test07() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
    }

    /**
     * This test checks that addFirst and get work.
     */
    @Test
    public void Test08() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addFirst(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(0) == start);
        }
    }

    @Test
    public void Test09() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addFirst(start);
            assertTrue(sl.size == start);
            assertTrue(sl.getRecursive(0) == start);
        }
    }

    @Test
    public void Test10() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.getRecursive(start - 1) == start);
        }
    }

    @Test
    public void Test11() {
        int repeatSize = 1000;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        int sizeTracker = 0;
        for (int start = repeatSize; start > -repeatSize; start--) {
            if (start >= 0) {
                sl.addLast(start);
                assertTrue(sl.size == ((repeatSize - start) + 1));
                assertTrue(sl.getRecursive((repeatSize - start)) == start);
                sizeTracker = ((repeatSize - start) + 1);
            } else if (start < 0) {
                sl.addLast(start);
                assertTrue(sl.size == ((repeatSize - start) + 1));
                assertTrue(sl.getRecursive(start) == null);
                sizeTracker = ((repeatSize - start) + 1);
            }
        }
        assertTrue(sl.size == sizeTracker);
    }

    @Test
    public void Test12() {
        int repeatSize = 10;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.getRecursive(start - 1) == start);
        }
        assertTrue(sl.getRecursive(8) == 9);
        assertTrue(sl.getRecursive(9) == null);
        assertTrue(sl.getRecursive(10000) == null);
        assertTrue(sl.getRecursive(10) == null);
        assertTrue(sl.getRecursive(-10) == null);
        assertTrue(sl.getRecursive(-1) == null);
    }

    @Test
    public void Test13() {
        int repeatSize = 10;
        SLList<Integer> sl = new SLList<>();
        assertTrue(sl.size == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
        assertTrue(sl.get(8) == 9);
        assertTrue(sl.get(9) == null);
        assertTrue(sl.get(10000) == null);
    }

    @Test
    public void Test14() {
        int repeatSize = 100;
        SLList<Integer> sl = new SLList<>();
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeFirst() == start);
            assertTrue(sl.size == (repeatSize - 1) - start);
        }
    }

    @Test
    public void Test15() {
        int repeatSize = 10;
        SLList<Integer> sl = new SLList<>();
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeFirst() == start);
            assertTrue(sl.size == (repeatSize - 1) - start);
        }
        assertTrue(sl.listSize() == 0);
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeFirst() == null);
            assertTrue(sl.size == 0);
        }
        assertTrue(sl.listSize() == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
    }

    @Test //
    public void Test16() {
        int repeatSize = 10;
        SLList<Integer> sl = new SLList<>();
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeLast() == repeatSize - start);
            assertTrue(sl.size == (repeatSize - 1) - start);
        }
        assertTrue(sl.listSize() == 0);
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeLast() == null);
            assertTrue(sl.size == 0);
        }
        assertTrue(sl.listSize() == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
    }

    @Test
    public void Test17() {
        int repeatSize = 10;
        SLList<Integer> sl = new SLList<>();
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeAt((repeatSize - 1) - start) == repeatSize - start);
            assertTrue(sl.size == (repeatSize - 1) - start);
        }
        assertTrue(sl.listSize() == 0);
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeAt((repeatSize - 1) - start) == null);
            assertTrue(sl.size == 0);
        }
        assertTrue(sl.listSize() == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
    }

    @Test
    public void Test18() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        assertNull(L.removeFirst());
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        for (int i = 0; i < max; i++)
            assertTrue(L.removeFirst() == i);
        assertTrue(L.listSize() == 0);
    }

    @Test
    public void Test19() {
        int repeatSize = 10;
        SLList<Integer> sl = new SLList<>();
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeAt(0) == start);
            assertTrue(sl.size == (repeatSize - 1) - start);
        }
        assertTrue(sl.listSize() == 0);
        for (int start = 1; start < repeatSize; start++) {
            assertTrue(sl.removeAt(0) == null);
            assertTrue(sl.size == 0);
        }
        assertTrue(sl.listSize() == 0);
        for (int start = 1; start < repeatSize; start++) {
            sl.addLast(start);
            assertTrue(sl.size == start);
            assertTrue(sl.get(start - 1) == start);
        }
    }

    @Test
    public void Test20() {
        int max = 5;
        SLList<Integer> L = new SLList<>();
        assertNull(L.removeAt(0));
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        assertTrue(L.removeAt(1) == 1);
        assertTrue(L.removeAt(2) == 3);
        assertTrue(L.removeAt(2) == 4);
        assertTrue(L.removeAt(0) == 0);
        assertTrue(L.listSize() == 1);
    }

    @Test
    public void Test21() {
        int max = 10;
        SLList<Integer> L = new SLList<>();
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        assertTrue(L.find(5) == 5);
        assertTrue(L.find(6) == 6);
        assertTrue(L.find(7) == 7);
        assertTrue(L.find(8) == 8);
    }
}