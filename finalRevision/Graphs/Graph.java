import java.util.*;
import java.util.stream.Collectors;

/* Adj Lists based GRAPH ADT */
public class Graph implements Iterable<Integer> {

    public class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;
            Edge e = (Edge) o;
            return e.to == this.to && e.from == this.from;
        }

        public String toString() {
            return String.format("(from: %s, to: %s)", this.from, this.to);
        }
    }

    LinkedList<Edge>[] adjLists;
    int vertexCount;
    int edgeCount;

    public Graph(int vertexCount) {
        this.adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            this.adjLists[i] = new LinkedList<>();
        }
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
    }

    public void addEdge(int from, int to, int weight) {
        LinkedList<Edge> L = this.adjLists[from];
        Edge newEdge = new Edge(from, to, weight);
        for (Edge e : L) {
            if (e.equals(newEdge)) {
                newEdge.weight = weight;
                return;
            }
        }
        L.add(newEdge);
        edgeCount++;
    }

    public void addUndirectedEdge(int from, int to, int weight) {
        this.addEdge(from, to, weight);
        this.addEdge(to, from, weight);
        this.edgeCount--;
    }

    public boolean isAdjacent(int from, int to) {
        LinkedList<Edge> L = this.adjLists[from];
        for (Edge e : L) {
            if (e.to == to) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> neighbors(int vertex) {
        return this.adjLists[vertex].stream().map((x) -> x.to).collect(Collectors.toList());
    }

    public int inDegree(int vertex) {
        int count = 0;
        for (LinkedList<Edge> LE : this.adjLists) {
            for (Edge e : LE) {
                if (e.from != vertex && e.to == vertex)
                    count++;
            }
        }
        return count;
    }

    public int outDegree(int vertex) {
        return this.adjLists[vertex].size();
    }

    public boolean pathExist(int start, int stop) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        HashSet<Integer> seen = new HashSet<>();
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (vertex == stop)
                return true;
            for (int v : neighbors(vertex)) {
                if (!seen.contains(v)) {
                    stack.push(v);
                }
            }
            seen.add(vertex);
        }
        return false;
    }

    public List<Integer> dfs(int start) {
        LinkedList<Integer> L = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        HashSet<Integer> seen = new HashSet<>();
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            L.add(vertex);
            for (int v : neighbors(vertex)) {
                if (!seen.contains(v)) {
                    stack.push(v);
                }
            }
            seen.add(vertex);
        }
        return L;
    }

    public List<Integer> bfs(int start) {
        LinkedList<Integer> L = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(start);
        HashSet<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            L.add(vertex);
            for (int v : neighbors(vertex)) {
                if (!seen.contains(v)) {
                    queue.addLast(v);
                }
            }
            seen.add(vertex);
        }
        return L;
    }

    public List<Integer> dfsPath(int start, int stop) {
        HashMap<Integer, Edge> edgeTo = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        Stack<Integer> fringe = new Stack<>();
        LinkedList<Integer> L = new LinkedList<>();
        fringe.push(start);
        while (!fringe.isEmpty()) {
            int vertex = fringe.pop();
            if (seen.contains(vertex))
                continue;
            for (Edge e : this.adjLists[vertex]) {
                if (!seen.contains(e.to)) {
                    edgeTo.put(e.to, e);
                    fringe.add(e.to);
                }
            }
            seen.add(vertex);
        }
        while (edgeTo.containsKey(stop)) {
            L.addFirst(stop);
            stop = edgeTo.get(stop).from;
        }
        if (stop != start)
            return new LinkedList<>();
        L.addFirst(start);
        return L;
    }

    public List<Integer> bfsPath(int start, int stop) {
        HashMap<Integer, Edge> edgeTo = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        LinkedList<Integer> fringe = new LinkedList<>();
        LinkedList<Integer> L = new LinkedList<>();
        fringe.addLast(start);
        while (!fringe.isEmpty()) {
            int vertex = fringe.removeFirst();
            if (seen.contains(vertex))
                continue;
            for (Edge e : this.adjLists[vertex]) {
                if (!seen.contains(e.to)) {
                    edgeTo.put(e.to, e);
                    fringe.addLast(e.to);
                }
            }
            seen.add(vertex);
        }
        while (edgeTo.containsKey(stop)) {
            L.addFirst(stop);
            stop = edgeTo.get(stop).from;
        }
        if (stop != start)
            return new LinkedList<>();
        L.addFirst(start);
        return L;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new TopologicalIterator();
    }

    public class TopologicalIterator implements Iterator<Integer> {

        Stack<Integer> fringe; // fringe will only contain vertices of indegree zero;
        HashMap<Integer, Integer> mapper; // vertex -> current indegree

        public TopologicalIterator() {
            this.fringe = new Stack<>();
            this.mapper = new HashMap<>();
            for (int i = 0; i < adjLists.length; i++) {
                if (inDegree(i) != 0) {
                    this.mapper.put(i, inDegree(i));
                } else {
                    this.fringe.push(i);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !this.fringe.isEmpty();
        }

        @Override
        public Integer next() {
            int vertex = this.fringe.pop();
            for (int neighbor : neighbors(vertex)) {
                this.mapper.put(neighbor, this.mapper.get(neighbor) - 1);
                if (this.mapper.get(neighbor) == 0) {
                    this.fringe.push(neighbor);
                }
            }
            return vertex;
        }
    }

    private void generateG2() {
        addEdge(0, 1, 0);
        addEdge(0, 2, 0);
        addEdge(0, 4, 0);
        addEdge(1, 2, 0);
        addEdge(2, 3, 0);
        addEdge(4, 3, 0);
    }

    public static void main(String[] args) {
        Graph g2 = new Graph(5);
        g2.generateG2();
        for (int i : g2) {
            System.out.println(i);
        }

    }

    public List<Integer> dijkstra(int start, int stop) {
        HashSet<Integer> marked = new HashSet<>();
        LinkedList<Integer> L = new LinkedList<>();
        HashMap<Integer, Edge> edgeTo = new HashMap<>();
        HashMap<Integer, Integer> distTo = new HashMap<>();
        PriorityQueue<Integer> fringe = new PriorityQueue<>((x, y) -> distTo.get(x) - distTo.get(y));
        distTo.put(start, 0);
        fringe.add(start);
        while (!fringe.isEmpty()) {
            int vertex = fringe.poll();
            if (vertex == stop)
                break;
            if (marked.contains(vertex))
                continue;
            for (Edge e : adjLists[vertex]) {
                if (!marked.contains(e.to)) {
                    if (distTo.containsKey(e.to) && distTo.get(e.from) + e.weight < distTo.get(e.to)) {
                        distTo.put(e.to, distTo.get(e.from) + e.weight);
                        edgeTo.put(e.to, e);
                        fringe.add(e.to);
                    } else if (!distTo.containsKey(e.to)) {
                        distTo.put(e.to, distTo.get(e.from) + e.weight);
                        edgeTo.put(e.to, e);
                        fringe.add(e.to);
                    }
                }
            }
            marked.add(vertex);
        }
        while (edgeTo.containsKey(stop)) {
            L.addFirst(stop);
            stop = edgeTo.get(stop).from;
        }
        if (start != stop)
            return new LinkedList<>();
        L.addFirst(start);
        return L;
    }

    public List<Integer> AStar(int start, int stop) {
        HashMap<Integer, Integer> heuristic = new HashMap<>();
        for (int i = 0; i < vertexCount; i++) {
            heuristic.put(i, i);
        }
        HashSet<Integer> marked = new HashSet<>();
        LinkedList<Integer> L = new LinkedList<>();
        HashMap<Integer, Edge> edgeTo = new HashMap<>();
        HashMap<Integer, Integer> distTo = new HashMap<>();
        PriorityQueue<Integer> fringe = new PriorityQueue<>((x, y) -> distTo.get(x) - distTo.get(y));
        distTo.put(start, 0);
        fringe.add(start);
        while (!fringe.isEmpty()) {
            int vertex = fringe.poll();
            if (vertex == stop)
                break;
            if (marked.contains(vertex))
                continue;
            for (Edge e : adjLists[vertex]) {
                if (!marked.contains(e.to)) {
                    if (distTo.containsKey(e.to) && distTo.get(e.from) + e.weight + heuristic.get(e.to) < distTo.get(e.to)) {
                        distTo.put(e.to, distTo.get(e.from) + e.weight);
                        edgeTo.put(e.to, e);
                        fringe.add(e.to);
                    } else if (!distTo.containsKey(e.to)) {
                        distTo.put(e.to, distTo.get(e.from) + e.weight);
                        edgeTo.put(e.to, e);
                        fringe.add(e.to);
                    }
                }
            }
            marked.add(vertex);
        }
        while (edgeTo.containsKey(stop)) {
            L.addFirst(stop);
            stop = edgeTo.get(stop).from;
        }
        if (start != stop)
            return new LinkedList<>();
        L.addFirst(start);
        return L;
    }

    public Graph prims(int start) {
        Graph T = new Graph(vertexCount);
        HashSet<Integer> marked = new HashSet<>();
        LinkedList<Integer> L = new LinkedList<>();
        HashMap<Integer, Edge> edgeTo = new HashMap<>();
        HashMap<Integer, Integer> distTo = new HashMap<>();
        PriorityQueue<Integer> fringe = new PriorityQueue<>((x, y) -> distTo.get(x) - distTo.get(y));
        distTo.put(start, 0);
        fringe.add(start);
        while (!fringe.isEmpty()) {
            int vertex = fringe.poll();
            if (marked.contains(vertex))
                continue;
            for (Edge e : adjLists[vertex]) {
                if (!marked.contains(e.to)) {
                    if (distTo.containsKey(e.to) && e.weight < distTo.get(e.to)) {
                        distTo.put(e.to, e.weight);
                        edgeTo.put(e.to, e);
                        fringe.add(e.to);
                    } else if (!distTo.containsKey(e.to)) {
                        distTo.put(e.to, e.weight);
                        edgeTo.put(e.to, e);
                        fringe.add(e.to);
                    }
                }
            }
            marked.add(vertex);
        }
        for (Edge e : edgeTo.values()) {
            T.addUndirectedEdge(e.from, e.to, e.weight);
        }
        return T;
    }

    public Graph kruskals() {
        Graph T = new Graph(vertexCount);
        LinkedList<Edge> L = new LinkedList<>();
        for (LinkedList<Edge> LL : adjLists) {
            L.addAll(LL);
        }
        WeightedQUPC w = new WeightedQUPC(vertexCount);
        L.sort((x, y) -> x.weight - y.weight);
        Iterator<Edge> i = L.iterator();
        while (i.hasNext()) {
            Edge e = i.next();
            if (w.isConnect(e.from, e.to)) {
                continue;
            }
            w.union(e.from, e.to);
            T.addUndirectedEdge(e.from, e.to, e.weight);
        }
        return T;
    }

}