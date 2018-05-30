import java.util.*;

public class RouteBetweenNodes {
    private static final boolean DEV_MODE = false;

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

    private ArrayList<Integer> makeDeepCopyInteger(ArrayList<Integer> a) {
        return new ArrayList<>(a);
    }

    ArrayList<Integer> testConnectivityBFSReturnPath(boolean[][] graph, int v1, int v2) {
        int numOfVertex = graph.length;
        HashSet<Integer> visited = new HashSet<>();
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> start = new ArrayList<>();
        start.add(v1);
        queue.add(start);
        while (!queue.isEmpty()) {
            ArrayList<Integer> currentPath = queue.poll();
            int currentVertex = currentPath.get(currentPath.size() - 1);
            visited.add(currentVertex);
            for (int i = 0; i < numOfVertex; i++) {
                if (i != currentVertex && graph[currentVertex][i]) {
                    ArrayList<Integer> nextPath = new ArrayList<>(currentPath);
                    nextPath.add(i);
                    if (i == v2) return nextPath;
                    else if (!visited.contains(i)) queue.add(nextPath);
                }
            }
        }
        return null;
    }

    ArrayList<Integer> testConnectivityBFSReturnPathMoreEfficient(boolean[][] graph, int v1, int v2) {
        int numOfVertex = graph.length;
        HashMap<Integer, Integer> visited = new HashMap<>();
        Queue<QueueElem> queue = new LinkedList<>();
        ArrayList<Integer> start = new ArrayList<>();
        start.add(v1);
        queue.add(new QueueElem(v1, -1));
        while (!queue.isEmpty()) {
            QueueElem currentElem = queue.poll();
            int currentVertex = currentElem.nodeNum;
            visited.put(currentVertex, currentElem.from);
            for (int i = 0; i < numOfVertex; i++) {
                if (i != currentVertex && graph[currentVertex][i]) {
                    QueueElem nextElem = new QueueElem(i, currentVertex);
                    if (!visited.containsKey(i)) queue.add(nextElem);
                    if (i == v2) {
                        ArrayList<Integer> path = new ArrayList<>();
                        path.add(i);
                        int currentTraceBack = currentVertex;
                        path.add(currentTraceBack);
                        while (visited.get(currentTraceBack) != -1) {
                            currentTraceBack = visited.get(currentTraceBack);
                            path.add(currentTraceBack);
                        }
                        if (DEV_MODE) System.out.println(path);
                        return path;

                    }
                }
            }
        }
        return null;
    }

    class QueueElem {
        final int nodeNum;
        final int from;

        QueueElem(int nodeNum, int from) {
            this.nodeNum = nodeNum;
            this.from = from;
        }
    }
}
