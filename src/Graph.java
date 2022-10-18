import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Graph {
    private List<Edge> edges;

    public Graph(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
