public class Main {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");

        WeightedGraph graph = new WeightedGraph();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2, 1);
        graph.addEdge(v2, v3, 2);
        graph.addEdge(v3, v4, 3);
        graph.addEdge(v1, v4, 10);

        System.out.println("Breadth First Search:");
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, v1);
        System.out.println("Path from A to D: " + bfs.pathTo(v4));

        System.out.println("Dijkstra's Search:");
        DijkstraSearch dijkstra = new DijkstraSearch(graph, v1);
        System.out.println("Shortest path from A to D: " + dijkstra.pathTo(v4));
        System.out.println("Distance from A to D: " + dijkstra.distTo(v4));
    }
}
