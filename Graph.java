public class Graph {

    LinkedList<Vertex> adjList;
    private int noOfEdges;
    private int noOfVertices;
    private String[] shortestPaths;


    public Graph() {
        adjList = new LinkedList<>();
        noOfEdges = 0;
    }

    public void addVertex(String n) {
        Vertex newData = new Vertex(n);
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).name.equals(n)) {
                return;
            }
        }
        newData.index = noOfVertices;
        adjList.add(newData);

        noOfVertices++;
    }

    public int getVertexIndex(String name) {
        if (!vertexExist(name)) return -1;
        for (int i = 0; i < noOfVertices; i++) {
            if (adjList.get(i).name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addEdge(String n1, String n2, int distance) {
        int i = getVertexIndex(n1);
        int j = getVertexIndex(n2);
        Edge edge = new Edge(this, n1, n2, distance);
        adjList.get(i).edges.add(edge);
        adjList.get(j).edges.add(edge);
        noOfEdges++;
    }

    public Vertex findVertex(String name) {
        for (int i = 0; i < noOfVertices; i++) {
            if (adjList.get(i).name.equals(name)) {
                return adjList.get(i);
            }
        }
        return null;
    }

    public boolean vertexExist(String name) {
        for (int i = 0; i < noOfVertices; i++) {
            if (adjList.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void deleteVertex(String name) {
        if (!vertexExist(name)) return;
        Vertex found = findVertex(name);
        for (int i = 0; i < found.vertices.size(); i++) {
            found.vertices.get(i).vertices.delete(found);
        }
        adjList.delete(found);
    }

    public int getNoOfEdges() {
        return noOfEdges;
    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    private void dijkstraDistance(String sourceName) {
        shortestPaths = new String[noOfVertices];
        Vertex source = findVertex(sourceName);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.enqueue(new Pair(source, sourceName + "", 0));
        boolean[] visited = new boolean[noOfVertices];
        while (!pq.isEmpty()) {
            Pair rem = pq.dequeue();
            if (visited[getVertexIndex(rem.v.name)]) {
                continue;
            }
            visited[getVertexIndex(rem.v.name)] = true;
            shortestPaths[rem.v.index] = "The Shortest route in terms of distance from " + sourceName + " to " + rem.v.name + " is: " + "\n" + rem.path + "\nwhich makes up a total distance of " + rem.totalDistance + " Kilometers.";
            for (int i = 0; i < rem.v.vertices.size(); i++) {
                Vertex v = rem.v.vertices.get(i);
                Edge e = rem.v.edges.get(i);
                if (!visited[getVertexIndex(v.name)]) {
                    pq.enqueue(new Pair(v, "" + rem.path + "->" + v.name, rem.totalDistance + e.distance));
                }
            }
        }
    }

    public void getShortestDistance(String sourceName, String destination) {
        try {
            dijkstraDistance(sourceName);
            Vertex v = findVertex(destination);
            System.out.println(shortestPaths[v.index] + "\n");
        } catch (Exception e) {
            System.out.println("No such Vertex exist, Please enter the correct name of the Vertex from the map");
        }
    }

    public void displayAllStations() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("" + (i + 1) + ")" + adjList.get(i).name);
        }
        System.out.println();
    }


    public void displayMap() {
        String str = "";

        for (int i = 0; i < adjList.size(); i++) {
            Vertex person = adjList.get(i);
            String p = adjList.get(i).name + " -> [";

            for (int j = 0; j < person.vertices.size(); j++) {
                p += "(" + person.vertices.get(j).name + " -> " + person.edges.get(j).distance + " kms";
            }

            if (person.vertices.size() != 0) {
                p = p.substring(0, p.length() - 1);
            }

            p += "]\n";
            str += p;
        }

        System.out.println(str);
    }

}
