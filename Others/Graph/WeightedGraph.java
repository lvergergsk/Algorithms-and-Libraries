import java.util.HashSet;
import java.util.Objects;

public class WeightedGraph {
    public final int inf;
    private final boolean directed;
    private int numOfVertex;
    private int[][] adjacencyMatrix;

    WeightedGraph(int numOfVertex, boolean directed) {
        this.directed = directed;
        this.inf = Integer.MAX_VALUE;
        this.numOfVertex = numOfVertex;
        adjacencyMatrix = new int[numOfVertex][numOfVertex];
        for (int i = 0; i < numOfVertex; i++) {
            for (int j = 0; j < numOfVertex; j++) {
                adjacencyMatrix[i][j] = inf;
            }
        }
    }

    public int getWeight(int p, int q) {
        return adjacencyMatrix[p][q];
    }

    public int getTotalWeight() {
        int sum = 0;
        for (int i = 0; i < numOfVertex; i++) {
            if (directed) {
                for (int j = 0; j < numOfVertex; j++) {
                    if (adjacencyMatrix[i][j] != inf) sum += adjacencyMatrix[i][j];
                }
            } else {
                for (int j = i; j < numOfVertex; j++) {
                    if (adjacencyMatrix[i][j] != inf) sum += adjacencyMatrix[i][j];
                }
            }
        }
        return sum;
    }

    void addEdge(int p, int q, int w) {
        adjacencyMatrix[p][q] = w;
        if (!directed)
            adjacencyMatrix[q][p] = w;
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
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numOfVertex; i++) {
            if (directed) {
                for (int j = 0; j < numOfVertex; j++) {
                    if (!(adjacencyMatrix[i][j] == inf))
                        str.append(i + " -> " + j + " = " + adjacencyMatrix[i][j] + "\n");
                }
            } else {
                for (int j = i; j < numOfVertex; j++) {
                    if (!(adjacencyMatrix[i][j] == inf))
                        str.append(i + " <-> " + j + " = " + adjacencyMatrix[i][j] + "\n");
                }
            }
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

    class Vertex<T> {
        final int id;
        final String name;
        T data;

        Vertex(int id) {
            this.id = id;
            this.name = Integer.toString(id);
        }

        Vertex(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return id == vertex.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

}
