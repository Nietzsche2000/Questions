import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void dijkstra() {
        Graph g1 = new Graph(7);
        g1.addEdge(0, 1, 2);
        g1.addEdge(0, 2, 1);
        g1.addEdge(1, 2, 5);
        g1.addEdge(1, 4, 3);
        g1.addEdge(1, 3, 11);
        g1.addEdge(2, 5, 15);
        g1.addEdge(4, 6, 5);
        g1.addEdge(4, 5, 4);
        g1.addEdge(4, 2, 1);
        g1.addEdge(6, 3, 1);
        g1.addEdge(6, 5, 1);
        g1.addEdge(3, 4, 2);
        System.out.println(g1.dijkstra(0, 5));
    }

    @Test
    public void astar() {
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1, 2);
        g1.addEdge(0, 2, 6);
        g1.addEdge(1, 2, 0);
        g1.addEdge(1, 3, 3);
        System.out.println(g1.dijkstra(0, 2));
    }

    @Test
    public void prims() {
        Graph g1 = new Graph(4);
        g1.addUndirectedEdge(0, 1, 3);
        g1.addUndirectedEdge(1, 2, 2);
        g1.addUndirectedEdge(0, 2, 1);
        g1.addUndirectedEdge(1, 3, 7);
        g1.addUndirectedEdge(2, 3, 6);
        g1.addUndirectedEdge(0, 3, 8);
        Graph T = g1.prims(0);
        Graph K = g1.kruskals();
        System.out.println(Arrays.toString(T.adjLists));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(K.adjLists));
    }
}