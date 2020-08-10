import java.util.*;
import java.util.stream.Collectors;

public class Graph implements Iterable<Integer> {

    private LinkedList<Edge>[] adjLists;
    private int vertexCount;

    /* Initializes a graph with NUMVERTICES vertices and no Edges. */
    public Graph(int numVertices) {
        adjLists = (LinkedList<Edge>[]) new LinkedList[numVertices];
        for (int k = 0; k < numVertices; k++) {
            adjLists[k] = new LinkedList<Edge>();
        }
        vertexCount = numVertices;
    }

    /* Adds a directed Edge (V1, V2) to the graph. */
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, 0);
    }

    /* Adds an undirected Edge (V1, V2) to the graph. */
    public void addUndirectedEdge(int v1, int v2) {
        addUndirectedEdge(v1, v2, 0);
    }

    /* Adds a directed Edge (V1, V2) to the graph with weight WEIGHT. If the
       Edge already exists, replaces the current Edge with a new Edge with
       weight WEIGHT. */
    public void addEdge(int v1, int v2, int weight) {
        // TODO: YOUR CODE HERE
        LinkedList<Edge> vertex = adjLists[v1];
        for (Edge e : vertex) {
            if (e.to == v2) {
                e.weight = weight;
                return;
            }
        }
        vertex.addLast(new Edge(v1, v2, weight));
    }

    /* Adds an undirected Edge (V1, V2) to the graph with weight WEIGHT. If the
       Edge already exists, replaces the current Edge with a new Edge with
       weight WEIGHT. */
    public void addUndirectedEdge(int v1, int v2, int weight) {
        // TODO: YOUR CODE HERE
        this.addEdge(v1, v2, weight);
        this.addEdge(v2, v1, weight);
    }

    /* Returns true if there exists an Edge from vertex FROM to vertex TO.
       Returns false otherwise. */
    public boolean isAdjacent(int from, int to) {
        // TODO: YOUR CODE HERE
        LinkedList<Edge> vertex = adjLists[from];
        for (Edge e : vertex) {
            if (e.to == to) {
                return true;
            }
        }
        return false;
    }

    /* Returns a list of all the vertices u such that the Edge (V, u)
       exists in the graph. */
    public List<Integer> neighbors(int v) {
        // TODO: YOUR CODE HERE
        LinkedList<Edge> neighbors = adjLists[v];
        return neighbors.stream().map((x) -> x.to).collect(Collectors.toList());
    }

    /* Returns the number of incoming Edges for vertex V. */
    public int inDegree(int v) {
        // TODO: YOUR CODE HERE
        int total = 0;
        for (LinkedList<Edge> edges : this.adjLists) {
            for (Edge e : edges) {
                if (e.to == v)
                    total++;
            }
        }
        return total;
    }

    /* Returns an Iterator that outputs the vertices of the graph in topological
       sorted order. */
    public Iterator<Integer> iterator() {
        return new TopologicalIterator();
    }

    /**
     * A class that iterates through the vertices of this graph,
     * starting with a given vertex. Does not necessarily iterate
     * through all vertices in the graph: if the iteration starts
     * at a vertex v, and there is no path from v to a vertex w,
     * then the iteration will not include w.
     */
    private class DFSIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        private HashSet<Integer> visited;

        public DFSIterator(Integer start) {
            fringe = new Stack<>();
            visited = new HashSet<>();
            fringe.push(start);
        }

        public boolean hasNext() {
            if (!fringe.isEmpty()) {
                int i = fringe.pop();
                while (visited.contains(i)) {
                    if (fringe.isEmpty()) {
                        return false;
                    }
                    i = fringe.pop();
                }
                fringe.push(i);
                return true;
            }
            return false;
        }

        public Integer next() {
            int curr = fringe.pop();
            ArrayList<Integer> lst = new ArrayList<>();
            for (int i : neighbors(curr)) {
                lst.add(i);
            }
            lst.sort((Integer i1, Integer i2) -> -(i1 - i2));
            for (Integer e : lst) {
                fringe.push(e);
            }
            visited.add(curr);
            return curr;
        }

        //ignore this method
        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    /* Returns the collected result of performing a depth-first search on this
       graph's vertices starting from V. */
    public List<Integer> dfs(int v) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new DFSIterator(v);

        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }

    /* Returns true iff there exists a path from START to STOP. Assumes both
       START and STOP are in this graph. If START == STOP, returns true. */
    public boolean pathExists(int start, int stop) {
        // TODO: YOUR CODE HERE
        return dfs(start).contains(stop);
    }


    /* Returns the path from START to STOP. If no path exists, returns an empty
       List. If START == STOP, returns a List with START. */
    public List<Integer> path(int start, int stop) {
        // TODO: YOUR CODE HERE
        if (!this.pathExists(start, stop))
            return new ArrayList<>();
        Iterator<Integer> dfsIterator = new DFSIterator(start);
        LinkedList<Integer> L = new LinkedList<>();
        LinkedList<Integer> fin = new LinkedList<>();
        while (dfsIterator.hasNext()) {
            int vertex = dfsIterator.next();
            L.addLast(vertex);
            if (vertex == stop)
                break;
        }
        fin.addLast(stop);
        while (start != stop) {
//            stop = L.removeLast();
//            fin.addFirst(stop);
//            if (this.isAdjacent(L.getLast(), stop))
//                continue;
//            L.removeLast();
            for (int vertex : L) {
                if (isAdjacent(vertex, stop)) {
                    fin.addFirst(vertex);
                    stop = vertex;
                    break;
                }
            }
        }
        return fin;
    }

    public List<Integer> topologicalSort() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new TopologicalIterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }

    private class TopologicalIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;

        // TODO: Instance variables here!
        int[] currInDegree;
        HashSet<Integer> seen;

        TopologicalIterator() {
            this.fringe = new Stack<Integer>();
            // TODO: YOUR CODE HERE
            this.currInDegree = new int[adjLists.length];
            this.seen = new HashSet<>();
            int start = -1;
            for (int i = 0; i < currInDegree.length; i++) {
                this.currInDegree[i] = inDegree(i);
                if (this.currInDegree[i] == 0)
                    start = i;
            }
            this.fringe.push(start);
        }

        public boolean hasNext() {
            // TODO: YOUR CODE HERE
            return !this.fringe.isEmpty() && this.fringe.peek() != -1;
        }

        public Integer next() {
            // TODO: YOUR CODE HERE
            int vertex = this.fringe.pop();
            for (int neighbor : neighbors(vertex)) {
                if (!seen.contains(neighbor)) {
                    this.currInDegree[neighbor]--;
                }
                if (this.currInDegree[neighbor] == 0 && !seen.contains(neighbor)) {
                    this.fringe.push(neighbor);
                }
            }
            seen.add(vertex);
            return vertex;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public List<Integer> shortestPath(int start, int stop) {
        // TODO: YOUR CODE HERE
        boolean[] marked = new boolean[this.vertexCount];
        LinkedList<Integer> L = new LinkedList<>();
        HashMap<Integer, Integer> distTo = new HashMap<>();
        HashMap<Integer, Edge> edgeTo = new HashMap<>();
        PriorityQueue<Integer> fringe = new PriorityQueue<>(Comparator.comparingInt(distTo::get));
        distTo.put(start, 0);
        fringe.add(start);
        while (!fringe.isEmpty()) {
            int vertex = fringe.poll();
            if (vertex == stop)
                break;
            for (Edge e : this.adjLists[vertex]) {
                if (!marked[e.to]) {
                    if (!distTo.containsKey(e.to) || distTo.get(e.to) > (distTo.get(e.from) + e.weight)) {
                        distTo.put(e.to, e.weight + distTo.get(e.from));
                        edgeTo.put(e.to, e);
                    }
                    fringe.add(e.to);
                }
            }
            marked[vertex] = true;
        }
        while (edgeTo.containsKey(stop)) {
            L.addFirst(stop);
            stop = edgeTo.get(stop).from;
        }
        L.addFirst(start);
        if (start == stop)
            return L;
        return new LinkedList<>();
    }

    private class Edge {

        private int from;
        private int to;
        private int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return "(" + from + ", " + to + ", weight = " + weight + ")";
        }

    }

    private void generateG1() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(4, 3);
    }

    private void generateG2() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(4, 3);
    }

    private void generateG3() {
        addUndirectedEdge(0, 2);
        addUndirectedEdge(0, 3);
        addUndirectedEdge(1, 4);
        addUndirectedEdge(1, 5);
        addUndirectedEdge(2, 3);
        addUndirectedEdge(2, 6);
        addUndirectedEdge(4, 5);
    }

    private void generateG4() {
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(4, 2);
    }

    private void printDFS(int start) {
        System.out.println("DFS traversal starting at " + start);
        List<Integer> result = dfs(start);
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
    }

    private void printPath(int start, int end) {
        System.out.println("Path from " + start + " to " + end);
        List<Integer> result = path(start, end);
        if (result.size() == 0) {
            System.out.println("No path from " + start + " to " + end);
            return;
        }
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
    }

    private void printTopologicalSort() {
        System.out.println("Topological sort");
        List<Integer> result = topologicalSort();
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }

    public static void main(String[] args) {
//        Graph g1 = new Graph(5);
//        g1.generateG1();
//        g1.printDFS(0);
//        g1.printDFS(2);
//        g1.printDFS(3);
//        g1.printDFS(4);
//
//        g1.printPath(0, 3);
//        g1.printPath(0, 4);
//        g1.printPath(1, 3);
//        g1.printPath(1, 4);
//        g1.printPath(4, 0);
//
//        Graph g2 = new Graph(5);
//        g2.generateG2();
//        g2.printTopologicalSort();
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
//        g1.generateG1();
//        g1.printDFS(0);
//        g1.printDFS(2);
//        g1.printDFS(3);
//        g1.printDFS(4);
//
//        g1.printPath(0, 3);
//        g1.printPath(0, 4);
//        g1.printPath(1, 3);
//        g1.printPath(1, 4);
//        g1.printPath(4, 0);
//
//        Graph g2 = new Graph(5);
//        g2.generateG2();
//        g2.printTopologicalSort();
        System.out.println(g1.shortestPath(0, 3));
    }
}