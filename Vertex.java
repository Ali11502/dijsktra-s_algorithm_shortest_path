public class Vertex {
    public String name;

    public int index;
    public LinkedList<Edge> edges = new LinkedList<>();

    public LinkedList<Vertex> vertices = new LinkedList<>();

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
