
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

    @Test
    public void Test03() {
        int listSize = 10;
        int listSizeT2 = listSize * 2;
        DLList<Integer> dl = new DLList<>();
        for (int index = 0; index < listSize; index += 1) {
            dl.addLast(index);
        }
        for (int index = 0; index < listSize; index += 1) {
            assertTrue(dl.get(index) == index);
        }
        for (int index = listSize; index < listSizeT2; index += 1) {
            assertTrue(dl.get(index) == null);
        }
    }

    @Test
    public void Test04() {
        int listSize = 10;
        DLList<Integer> dl = new DLList<>();
        for (int index = 0; index < listSize; index += 1) {
            dl.addLast(index);
        }
        int movingValue = 4;
        for (int index = 0; index <= 5; index += 1) {
            Integer value = dl.removeAtFast(4);
            assertTrue(value == movingValue);
            movingValue += 1;
        }
    }

}

