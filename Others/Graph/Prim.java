import java.util.ArrayList;
import java.util.HashSet;

interface MST {
}

public class Prim implements MST {
    private static final boolean DEV_MODE = false;

    private WeightedGraph weightedGraph;
    private HashSet<Integer> unVisited;
    private ArrayList<WeightedGraph> MST;

    Prim(WeightedGraph weightedGraph) {
        MST = new ArrayList<>();
        this.unVisited = weightedGraph.getAllVertex();
        this.weightedGraph = weightedGraph;
        while (!unVisited.isEmpty())
            MST.add(computeMST());
    }

    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(7);
        weightedGraph.addUndirectedEdge(0, 1, 2);
        weightedGraph.addUndirectedEdge(0, 2, 3);
        weightedGraph.addUndirectedEdge(0, 3, 3);
        weightedGraph.addUndirectedEdge(1, 2, 4);
        weightedGraph.addUndirectedEdge(1, 4, 3);
        weightedGraph.addUndirectedEdge(2, 3, 5);
        weightedGraph.addUndirectedEdge(2, 4, 1);
        weightedGraph.addUndirectedEdge(2, 5, 6);
        weightedGraph.addUndirectedEdge(3, 5, 7);
        weightedGraph.addUndirectedEdge(4, 5, 8);
        weightedGraph.addUndirectedEdge(5, 6, 9);
        System.out.println(weightedGraph);

        Prim prim = new Prim(weightedGraph);

        ArrayList<WeightedGraph> MST = prim.getMST();

        for (WeightedGraph w : MST) System.out.println(w);
    }

    public ArrayList<WeightedGraph> getMST() {
        return MST;
    }

    public WeightedGraph computeMST() {
        HashSet<Integer> visited = new HashSet<>();
        int numOfVertex = weightedGraph.getNumOfVertex();

        WeightedGraph res = new WeightedGraph(numOfVertex);

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
                res.addUndirectedEdge(minP, minQ, minWeight);
                unVisited.remove(minQ);
                visited.add(minQ);
            }

        }

        return res;
    }
}
