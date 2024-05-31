public class Pair implements Comparable<Pair> {
    public Vertex v;
    public String path;
    public int totalDistance;

    public Pair(Vertex v, String path, int totalDistance) {
        this.v = v;
        this.path = path;
        this.totalDistance = totalDistance;
    }

    @Override
    public int compareTo(Pair o) {
        return this.totalDistance - o.totalDistance;
    }
}
