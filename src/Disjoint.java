import java.util.*;

public class Disjoint {
    private Map<Integer, Integer> parents ;
    private int vertexCount;

    private List<Edge> edges;

    public Disjoint(List<Edge> edges, int vertexCount) {
        this.edges = edges;
        this.vertexCount = vertexCount;
        this.parents = new HashMap<>();

        for (int i = 0; i < vertexCount; i++) {
            parents.put(i, i);
        }
    }

    private int find(int k) {
        if (parents.get(k) == k) {
            return k;
        }
        return find(parents.get(k));
    }

    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parents.put(x, y);
    }

    public List<Edge> getMinimumSpanningTree() {
        Collections.sort(edges, Comparator.comparingInt(e -> e.getWeight()));

        int index = 0;
        List<Edge> mst = new ArrayList<>();
        while (mst.size() != vertexCount - 1) {
            Edge currentEdge = edges.get(index++);

            // get absolute parent
            int x = find(currentEdge.getX());
            int y = find(currentEdge.getY());

            if (x != y) {
                mst.add(currentEdge);
                union(x, y);
            }
        }
        return mst;
    }
}
