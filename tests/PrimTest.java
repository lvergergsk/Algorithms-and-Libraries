import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimTest {
    @Test
    public void primTest1() {
        WeightedGraph weightedGraph = new WeightedGraph(7, false);
        weightedGraph.addEdge(0, 1, 2);
        weightedGraph.addEdge(0, 2, 3);
        weightedGraph.addEdge(0, 3, 3);
        weightedGraph.addEdge(1, 2, 4);
        weightedGraph.addEdge(1, 4, 3);
        weightedGraph.addEdge(2, 3, 5);
        weightedGraph.addEdge(2, 4, 1);
        weightedGraph.addEdge(2, 5, 6);
        weightedGraph.addEdge(3, 5, 7);
        weightedGraph.addEdge(4, 5, 8);
        weightedGraph.addEdge(5, 6, 9);

        Prim prim = new Prim(weightedGraph);
        assertEquals(24, prim.getMSTWeight());
    }

    @Test
    public void primTest2() {
        WeightedGraph weightedGraph = new WeightedGraph(9, false);
        weightedGraph.addEdge(0, 1, 4);
        weightedGraph.addEdge(0, 7, 4);
        weightedGraph.addEdge(1, 7, 11);
        weightedGraph.addEdge(1, 2, 8);
        weightedGraph.addEdge(7, 8, 7);
        weightedGraph.addEdge(7, 6, 1);
        weightedGraph.addEdge(2, 8, 2);
        weightedGraph.addEdge(6, 8, 6);
        weightedGraph.addEdge(2, 3, 7);
        weightedGraph.addEdge(2, 5, 4);
        weightedGraph.addEdge(6, 5, 2);
        weightedGraph.addEdge(3, 5, 14);
        weightedGraph.addEdge(3, 4, 9);
        weightedGraph.addEdge(5, 4, 10);
        Prim prim = new Prim(weightedGraph);
        assertEquals(33, prim.getMSTWeight());
    }

    @Test(expected = RuntimeException.class)
    public void primTest3(){
        WeightedGraph weightedGraph = new WeightedGraph(2, false);
        Prim prim=new Prim(weightedGraph);
    }
}