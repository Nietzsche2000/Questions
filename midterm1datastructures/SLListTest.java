import org.junit.Test;
import org.junit.Assert.*;

public class SLListTest{

    @Test
    public void addLast(){
        SLList<Integer> L = new SLList<>();
        for(int i = 0; i < 10; i++)
            L.addLastRecursive(i);

    }
}
