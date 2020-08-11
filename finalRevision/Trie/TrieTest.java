import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void insert() {
    }

    @Test
    public void contains() {
        Trie t = new Trie();
        t.insert("asdjk");
        assertTrue(t.contains("asdjk"));
        assertFalse(t.contains("asdj"));
        int max = 10000000;
        Object[] arr = new Object[max];
        for (int i = 0; i < max; i++) {
            int val = (int) Math.random() * 10000;
            arr[i] = val + "hello world";
            t.insert(val + "hello world");
        }

        for (int i = 0; i < arr.length; i++) {
            assertTrue(t.contains((String) arr[i]));
        }

    }
}