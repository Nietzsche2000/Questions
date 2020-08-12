import java.util.*;
import java.util.stream.Collectors;

/* Adj Lists based GRAPH ADT */
public class Graph {

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

    public class TopologicalIterator implements Iterator<Integer> {

        Stack<Integer> fringe; // fringe will only contain vertices of indegree zero;
        HashMap<Integer, Integer> mapper; // vertex -> current indegree

        public TopologicalIterator() {
            this.fringe = new Stack<>();
            this.mapper = new HashMap<>();
        }

        @Override
        public boolean hasNext() {
            return !this.fringe.isEmpty();
        }

        @Override
        public Integer next() {
            return null;
        }
    }

}