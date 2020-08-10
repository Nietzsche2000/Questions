import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void isAdjacent() {
        Graph G = new Graph(5);
        G.addEdge(0, 1, 1);
        G.addEdge(0, 2, 5);
        G.addEdge(2, 1, 2);
        G.addEdge(2, 3, 6);
        G.addEdge(3, 4, 9);
        G.addEdge(4, 2, 20);
        assertTrue(G.isAdjacent(0, 1));
        assertTrue(G.isAdjacent(0, 2));
        assertTrue(G.isAdjacent(2, 1));
        assertTrue(G.isAdjacent(2, 3));
        assertTrue(G.isAdjacent(3, 4));
        assertTrue(G.isAdjacent(4, 2));
        assertFalse(G.isAdjacent(1, 0));
        assertFalse(G.isAdjacent(2, 0));
        assertFalse(G.isAdjacent(1, 2));
        assertFalse(G.isAdjacent(3, 2));
        assertFalse(G.isAdjacent(4, 3));
        assertFalse(G.isAdjacent(2, 4));
        assertFalse(G.isAdjacent(0, 3));
        assertFalse(G.isAdjacent(0, 4));
        assertFalse(G.isAdjacent(2, 4));
    }

    @Test
    public void neighbors() {
        Graph G = new Graph(5);
        G.addEdge(0, 1, 1);
        G.addEdge(0, 2, 5);
        G.addEdge(2, 1, 2);
        G.addEdge(2, 3, 6);
        G.addEdge(3, 4, 9);
        G.addEdge(4, 2, 20);
        System.out.println(G.neighbors(0));
        System.out.println(G.neighbors(1));
        System.out.println(G.neighbors(2));
        System.out.println(G.neighbors(3));
        System.out.println(G.neighbors(4));
    }

    @Test
    public void inDegree() {
        Graph G = new Graph(5);
        G.addEdge(0, 1, 1);
        G.addEdge(0, 2, 5);
        G.addEdge(2, 1, 2);
        G.addEdge(2, 3, 6);
        G.addEdge(3, 4, 9);
        G.addEdge(4, 2, 20);
        assertEquals(G.inDegree(0), 0);
        assertEquals(G.inDegree(1), 2);
        assertEquals(G.inDegree(2), 2);
        assertEquals(G.inDegree(3), 1);
        assertEquals(G.inDegree(4), 1);
    }

    @Test
    public void path() {
        Graph G = new Graph(5);
        G.addEdge(0, 1, 1);
        G.addEdge(0, 2, 5);
        G.addEdge(2, 1, 2);
        G.addEdge(2, 3, 6);
        G.addEdge(3, 4, 9);
        G.addEdge(4, 2, 20);
        System.out.println(G.path(0, 4));
        System.out.println(G.path(0, 1));
        System.out.println(G.path(0, 3));
        System.out.println(G.path(0, 2));
        System.out.println(G.path(2, 4));
        System.out.println(G.path(4, 1));
    }
}