import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RouteBetweenNodes {

    boolean testConnectivityDFS(boolean[][] graph, int v1, int v2) {
        int numOfVertex = graph.length;
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(v1);
        while (!stack.empty()) {
            int currentVertex = stack.pop();
            visited.add(currentVertex);
            for (int i = 0; i < numOfVertex; i++) {
                if (i != currentVertex && graph[currentVertex][i]) {
                    if (i == v2) return true;
                    else if (!visited.contains(i)) stack.push(i);
                }
            }
        }
        return false;
    }

    boolean testConnectivityBFS(boolean[][] graph, int v1, int v2) {
        int numOfVertex = graph.length;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v1);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            visited.add(currentVertex);
            for (int i = 0; i < numOfVertex; i++) {
                if (i != currentVertex && graph[currentVertex][i]) {
                    if (i == v2) return true;
                    else if (!visited.contains(i)) queue.add(i);
                }
            }
        }
        return false;
    }
}
