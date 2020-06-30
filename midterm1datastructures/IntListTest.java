
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