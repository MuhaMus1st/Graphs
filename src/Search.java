import java.util.*;

public abstract class Search {
    protected WeightedGraph graph;
    protected Vertex start;
    protected Map<Vertex, Boolean> visited;
    protected Map<Vertex, Vertex> edgeTo;

    public Search(WeightedGraph graph, Vertex start) {
        this.graph = graph;
        this.start = start;
        visited = new HashMap<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return visited.getOrDefault(v, false);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex x = v; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
