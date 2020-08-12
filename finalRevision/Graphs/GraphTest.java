import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void dfsPath() {
        Graph G = new Graph(8);
        G.addEdge(1, 2, 2);
        G.addEdge(2, 3, 3);
        G.addEdge(3, 4, 4);
        G.addEdge(4, 1, 5);
        G.addEdge(4, 7, 1);
        G.addEdge(7, 1, 6);
        G.addEdge(7, 5, 3);
        G.addEdge(5, 6, 5);
        G.addEdge(6, 7, 2);
        G.addEdge(6, 3, 1);
        System.out.println(G.dfsPath(6, 1));
        System.out.println(G.bfsPath(6, 1));

    }
}