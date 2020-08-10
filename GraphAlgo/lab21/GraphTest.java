import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void prims() {
        Graph G = Graph.loadFromText("inputs/graphTestAllDisjoint.in");
        Graph T = G.prims(0);
        Graph K = G.kruskals();
        for(Edge e: K.getAllEdges()){
            System.out.println(e);
        }
    }

    @Test
    public void kruskals() {
    }
}