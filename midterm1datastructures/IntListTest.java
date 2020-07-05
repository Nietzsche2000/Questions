<<<<<<< HEAD
import org.junit.Test;
import static org.junit.Assert.*;

public class IntListTest{

    @Test
    public void addLastTest(){
        int max = 100;
        IntList L = new IntList(1, null);
        for(int i = 0; i < max; i++){
            L.addLast(i);
            L.addLastRecursive(i);
        }
        assertTrue(L.getLast() == 99);
        assertTrue(L.getLastIteration() == 99);
    }

    @Test
    public void ofTest(){
        IntList L = IntList.of(1, 2, 3, 4, 5);
    }

}
=======

import org.junit.Test;
import static org.junit.Assert.*;

public class IntListTest extends Object {

    @Test
    public void Test01() {
        int testSize = 10000;
        IntList ll = new IntList();
        assertTrue(ll.getLast() == 1);
        for (int i = 0; i < testSize; i++) {
            ll.addLast(i);
            assertTrue(ll.getLast() == i);
        }
    }

    @Test
    public void Test02() {
        int testSize = 10000;
        IntList ll = IntList.of(11, 120, 89, 90);
        assertTrue(ll.getLast() == 90);

    }
}
>>>>>>> origin/ryan
