public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 8);
        graph.addEdge("B", "C", 9);
        graph.addEdge("B", "D", 2);
        graph.addEdge("C", "D", 6);

        graph.getShortestDistance("A", "D");

    }
}
