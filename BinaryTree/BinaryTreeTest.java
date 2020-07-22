import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinaryTreeTest {
    @Test
    public void treeFormatTest() {
        BinarySearchTree<String> x = new BinarySearchTree<String>();
        x.add("C");
        x.add("A");
        x.add("E");
        x.add("B");
        x.add("D");
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        BinaryTree.print(x, "x");
        System.setOut(oldOut);
        assertEquals("x in preorder\nC A B E D \nx in inorder\nA B C D E \n\n".trim(),
                     outContent.toString().trim());
    }

    @Test
    public void treeAddTest() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(8);
        tree.add(7);
        tree.add(2);
        tree.add(3);
        tree.add(-10);
        tree.add(1);
        tree.add(9);
        tree.add(10);
        tree.add(12);
        tree.printInorder();
    }

    @Test
    public void testContains() {
        BinarySearchTree<String> x = new BinarySearchTree<String>();
        x.add("C");
        x.add("A");
        x.add("E");
        x.add("B");
        x.add("D");
        assertTrue(x.contains("C"));
        assertTrue(x.contains("B"));
        assertFalse(x.contains("Z"));
    }

    @Test
    public void testAdd() {
        BinarySearchTree<String> x = new BinarySearchTree<String>();
        x.add("C");
        x.add("A");
        x.add("E");
        x.add("B");
        x.add("D");
        x.add("Z");
        assertTrue(x.contains("C"));
        assertTrue(x.contains("B"));
        assertTrue(x.contains("Z"));
    }

    @Test
    public void testKthLargest() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(8);
        tree.add(7);
        tree.add(2);
        tree.add(3);
        tree.add(-10);
        tree.add(1);
        tree.add(9);
        tree.add(10);
        tree.add(12);
        tree.printInorder();
        // System.out.println(tree.findKthLargestSlow(0));
    }

}