import java.util.HashSet;

public class WeightedGraph {
    public final int inf;
    private int numOfVertex;
    private int[][] adjacencyMatrix;

    WeightedGraph(int numOfVertex) {
        this.inf = Integer.MAX_VALUE;
        this.numOfVertex = numOfVertex;
        adjacencyMatrix = new int[numOfVertex][numOfVertex];
        for (int i = 0; i < numOfVertex; i++) {
            for (int j = 0; j < numOfVertex; j++) {
                adjacencyMatrix[i][j] = i == j ? 0 : inf;
            }
        }
    }

    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(3);
        weightedGraph.addUndirectedEdge(0, 1, 2);
        weightedGraph.addDirectedEdge(0, 2, 3);
        weightedGraph.addUndirectedEdge(1, 2, 4);
        System.out.println(weightedGraph);
        HashSet<Integer> neighborsOf1 = weightedGraph.neighbors(1);
        for (int i : neighborsOf1) System.out.print(i + " ");
        System.out.println();
    }

    public int getWeight(int p, int q) {
        return adjacencyMatrix[p][q];
    }

    void addDirectedEdge(int p, int q, int w) {
        adjacencyMatrix[p][q] = w;
    }

    void addUndirectedEdge(int p, int q, int w) {
        addDirectedEdge(p, q, w);
        addDirectedEdge(q, p, w);
    }

    boolean adjacent(int p, int q) {
        if (adjacencyMatrix[p][q] != inf) return true;
        return false;
    }

    HashSet<Integer> neighbors(int p) {
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < numOfVertex; i++)
            if (adjacencyMatrix[p][i] != inf && i != p) res.add(i);
        return res;
    }

    HashSet<Integer> getAllVertex() {
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < numOfVertex; i++) res.add(i);
        return res;
    }

    @Override
    public String toString() {
//        TODO: improve.
        StringBuilder str = new StringBuilder("AdjMatrix:\n");
        for (int i = 0; i < numOfVertex; i++) {
            for (int j = 0; j < numOfVertex; j++) {
                if (adjacencyMatrix[i][j] == inf) str.append("  INF ");
                else str.append(String.format("%5d ", adjacencyMatrix[i][j]));
            }
            str.append("\n");
        }
        return str.toString();
    }

    public int getNumOfVertex() {
        return numOfVertex;
    }

    class Edge {
        final int p, q, weight;
        final boolean directed;

        Edge(int p, int q, int weight, boolean directed) {
            this.p = p;
            this.q = q;
            this.weight = weight;
            this.directed = directed;
        }
    }
}
