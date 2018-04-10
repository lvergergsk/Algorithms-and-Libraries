import java.util.HashSet;

public class Prim {
    private static final boolean DEV_MODE = false;

    private WeightedGraph weightedGraph;
    private HashSet<Integer> unVisited;
    private WeightedGraph MST;

    Prim(WeightedGraph weightedGraph) {
        this.unVisited = weightedGraph.getAllVertex();
        this.weightedGraph = weightedGraph;
        MST = computeMST();
        if (!unVisited.isEmpty()) throw new RuntimeException("The given graph is not connected");
    }

    public WeightedGraph getMST() {
        return MST;
    }

    public int getMSTWeight() {
        return MST.getTotalWeight();
    }

    public WeightedGraph computeMST() {
        HashSet<Integer> visited = new HashSet<>();
        int numOfVertex = weightedGraph.getNumOfVertex();

        WeightedGraph res = new WeightedGraph(numOfVertex, false);

        int oldSize = unVisited.size();

        Integer temp = unVisited.iterator().next();
        unVisited.remove(temp);
        visited.add(temp);

        while (unVisited.size() != oldSize) {

            if (DEV_MODE) System.out.println("Visited: " + visited.toString());
            if (DEV_MODE) System.out.println("Unvisited: " + unVisited.toString());

            oldSize = unVisited.size();
            int minWeight = weightedGraph.inf;

            int minP = -1, minQ = -1;
            for (int p : visited) {
                for (int q : unVisited) {
                    int weight = weightedGraph.getWeight(p, q);
                    if (weight < minWeight) {
                        minP = p;
                        minQ = q;
                        minWeight = weight;
                    }
                }
            }

            if (minWeight != weightedGraph.inf) {
                if (DEV_MODE)
                    System.out.println("edge(" + minP + "," + minQ + ") = " + minWeight);
                res.addEdge(minP, minQ, minWeight);
                unVisited.remove(minQ);
                visited.add(minQ);
            }

        }

        return res;
    }
}
