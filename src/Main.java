public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 2);

        // BFS
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "A");
        System.out.println("Breadth First Search Path from A to E: " + bfs.pathTo("E"));

        // Dijkstra
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "A");
        System.out.println("Dijkstra Search Path from A to E: " + dijkstra.pathTo("E"));




    }
}
