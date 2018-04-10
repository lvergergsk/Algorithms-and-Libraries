import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;

public class WeightedGraphTest {

    @Test
    public void neighborsTest1() {
        WeightedGraph weightedGraph = new WeightedGraph(3, false);
        weightedGraph.addEdge(0, 1, 2);
        weightedGraph.addEdge(0, 2, 3);
        weightedGraph.addEdge(1, 2, 4);
        HashSet<Integer> neighborsOf1 = weightedGraph.neighbors(1);
        assertTrue(neighborsOf1.contains(0));
        assertTrue(neighborsOf1.contains(2));
    }
}