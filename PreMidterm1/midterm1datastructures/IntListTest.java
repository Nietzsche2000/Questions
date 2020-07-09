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
