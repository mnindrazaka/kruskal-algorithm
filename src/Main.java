import java.util.*;

public class Main {
    public static void main(String[] args) {
        Edge edge1 = new Edge(0, 3, 3);
        Edge edge2 = new Edge(0, 4, 12);
        Edge edge3 = new Edge(3, 1, 5);
        Edge edge4 = new Edge(3, 2, 3);
        Edge edge5 = new Edge(1, 2, 2);
        Edge edge6 = new Edge(2, 4, 7);

        List<Edge> edges = Arrays.asList(edge1, edge2, edge3, edge4, edge5, edge6);

        Graph graph = new Graph(edges);
        int vertexCount = 5;

        Disjoint disjoint = new Disjoint(graph.getEdges(), vertexCount);
        List<Edge> mst = disjoint.getMinimumSpanningTree();

        for (Edge edge: mst) {
            System.out.println(edge.getX() + " " + edge.getY() + " " + edge.getWeight());
        }
    }
}