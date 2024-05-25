import java.util.*;

public class DijkstraSearch extends Search {
    private Map<Vertex, Double> distTo;
    private PriorityQueue<VertexDistancePair> pq;

    public DijkstraSearch(WeightedGraph graph, Vertex start) {
        super(graph, start);
        distTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDistancePair::getDistance));
        for (Vertex v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);
        pq.add(new VertexDistancePair(start, 0.0));
        while (!pq.isEmpty()) {
            VertexDistancePair vdp = pq.poll();
            Vertex v = vdp.getVertex();
            for (Edge e : graph.getEdges(v)) {
                relax(e);
            }
        }
    }

    private void relax(Edge e) {
        Vertex v = e.getSource();
        Vertex w = e.getDestination();
        if (distTo.get(w) > distTo.get(v) + e.getWeight()) {
            distTo.put(w, distTo.get(v) + e.getWeight());
            edgeTo.put(w, v);
            pq.add(new VertexDistancePair(w, distTo.get(w)));
            visited.put(w, true);
        }
    }

    public double distTo(Vertex v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }

    private static class VertexDistancePair {
        private Vertex vertex;
        private double distance;

        public VertexDistancePair(Vertex vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public Vertex getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }
}
