import java.util.*;

public class WeightedGraph {
    private final Map<Vertex, List<Edge>> adjacencyList = new HashMap<>();

    public void addVertex(Vertex vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        adjacencyList.get(source).add(new Edge(source, destination, weight));
    }

    public List<Edge> getEdges(Vertex vertex) {
        return adjacencyList.get(vertex);
    }

    public Set<Vertex> getVertices() {
        return adjacencyList.keySet();
    }

    public Map<Vertex, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }
}
