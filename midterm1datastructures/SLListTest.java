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
        int max = 10;
        SLList<Integer> L = new SLList<>();
        for (int i = 0; i < max; i++)
            L.addLastRecursive(i);
        L.reverse();
        for (int i = 0; i < max; i++) {
            assertTrue(L.get(i) == (max - 1));
            max--;
        }
    }


    //    @Test
//    public void equalsTest(){
//        int max = 3;
//        SLList<Integer> L = new SLList<>();
//        SLList<Integer> P = new SLList<>();
//        for(int i = 0; i < max; i++){
//            L.addLastRecursive(i);
//            P.addLastRecursive(i);
//        }
//        assertTrue(L.equals(P));
//    }



}
