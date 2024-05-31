public class Edge {
    public int distance;

    public Edge(Graph graph, String n1, String n2, int distance) {
        this.distance = distance;
        int i = graph.getVertexIndex(n1);
        int j = graph.getVertexIndex(n2);

        if (i != -1 && j != -1) {
            Vertex v1 = graph.adjList.get(i);
            Vertex v2 = graph.adjList.get(j);
            v1.vertices.add(v2);
            v2.vertices.add(v1);
        }
    }

}
