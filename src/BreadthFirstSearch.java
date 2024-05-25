import java.util.*;

public class BreadthFirstSearch extends Search {

    public BreadthFirstSearch(WeightedGraph graph, Vertex start) {
        super(graph, start);
        bfs(start);
    }

    private void bfs(Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, true);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge edge : graph.getEdges(v)) {
                Vertex w = edge.getDestination();
                if (!visited.getOrDefault(w, false)) {
                    visited.put(w, true);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
}
