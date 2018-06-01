public class UnweightedGraph {
    boolean[][] adjacencyMatrix;
    boolean[][] connectivity;
    int numOfVertex;

    UnweightedGraph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        adjacencyMatrix = new boolean[numOfVertex][numOfVertex];
    }

    void addDirectedEdge(int p, int q) {
        adjacencyMatrix[p][q] = true;
    }

    void addUndirectedEdge(int p, int q) {
        addDirectedEdge(p, q);
        addDirectedEdge(q, p);
    }

    boolean isConnected(int p, int q) {
        if (connectivity == null) {
            connectivity = new boolean[numOfVertex][numOfVertex];
//            TODO
        }

        return connectivity[p][q];
    }
}
