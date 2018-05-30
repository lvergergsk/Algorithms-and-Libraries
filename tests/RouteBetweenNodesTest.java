import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RouteBetweenNodesTest {
    boolean[][] graph = new boolean[][]{
            {true, true, true, false, false},
            {true, true, true, false, true},
            {true, true, true, false, false},
            {false, false, false, true, false},
            {false, false, false, false, true}
    };

    @Test
    public void testConnectivityDFS() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        assertEquals(false, routeBetweenNodes.testConnectivityDFS(graph, 1, 3));
        assertEquals(false, routeBetweenNodes.testConnectivityDFS(graph, 4, 3));
        assertEquals(true, routeBetweenNodes.testConnectivityDFS(graph, 1, 1));
        assertEquals(true, routeBetweenNodes.testConnectivityDFS(graph, 1, 2));
    }

    @Test
    public void testConnectivityBFS() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        assertEquals(false, routeBetweenNodes.testConnectivityBFS(graph, 1, 3));
        assertEquals(false, routeBetweenNodes.testConnectivityBFS(graph, 4, 3));
        assertEquals(true, routeBetweenNodes.testConnectivityBFS(graph, 1, 1));
        assertEquals(true, routeBetweenNodes.testConnectivityBFS(graph, 1, 2));
    }

    @Test
    public void testConnectivityBFSReturnPath() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        assertEquals(3, routeBetweenNodes.testConnectivityBFSReturnPath(graph, 0, 4).size());
        assertEquals(null, routeBetweenNodes.testConnectivityBFSReturnPath(graph, 0, 5));
    }

    @Test
    public void testConnectivityBFSReturnPathMoreEfficient() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        assertEquals(3, routeBetweenNodes.testConnectivityBFSReturnPathMoreEfficient(graph, 0, 4).size());
        assertEquals(null, routeBetweenNodes.testConnectivityBFSReturnPathMoreEfficient(graph, 0, 5));
    }

}