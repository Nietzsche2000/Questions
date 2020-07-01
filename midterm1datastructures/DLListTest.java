
import org.junit.Test;
import static org.junit.Assert.*;

public class DLListTest extends Object {

    @Test
    public void Test01() {
        int sampleSize = 10;
        DLList<Integer> dl = new DLList<>();
        for (int index = 0; index < sampleSize; index++) {
            assertTrue(dl.size == index);
            dl.addLast(index);
            assertTrue(dl.size == index + 1);
        }
    }

    @Test
    public void Test02() {
        int sampleSize = 10;
        DLList<Integer> dl = new DLList<>();
        for (int index = 0; index < sampleSize; index++) {
            assertTrue(dl.size == index);
            dl.addFirst(index);
            assertTrue(dl.size == index + 1);
        }
    }

}

