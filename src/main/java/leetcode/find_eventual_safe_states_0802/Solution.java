package leetcode.find_eventual_safe_states_0802;

import java.util.*;
//import java.util.logging.Logger;

class Solution {
    List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                ans.add(i);
        return ans;
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;
    private boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0) // color > 1, visited
            return color[node] == 2; // color == 2, children searched.

        color[node] = 1; // searched
        for (int nei: graph[node]) {
            if (color[node] == 2)
                continue;
            if (color[nei] == 1 || !dfs(nei, color, graph))
                return false;
        }

        color[node] = 2;
        return true;
    }
}


//class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

//    class StackNode {
//        final int node;
//        final int pathLength;
//
//        StackNode(int node, int pathLength) {
//            this.node = node;
//            this.pathLength = pathLength;
//        }
//    }
//
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        Stack<StackNode> stack = new Stack<>();
//        boolean[] visited = new boolean[graph.length];
//        boolean[] safe = new boolean[graph.length];
//        boolean[] checked = new boolean[graph.length];
//        ArrayList<Integer> path = new ArrayList<>();
//        Arrays.fill(safe, true);
//
//        dfs:
//        for (int i = 0; i < graph.length; i++) {
//            if (!checked[i]) {
//                stack.push(new StackNode(i, 1));
//                while (!stack.isEmpty()) {
//                    LOGGER.info("current path: " + path.toString());
//                    StackNode current = stack.pop();
//                    while (path.size() >= current.pathLength) {
//                        Integer removed = path.remove(path.size() - 1);
//                        visited[removed] = false;
//                    }
//                    if (visited[current.node]) {
//                        LOGGER.info("node: " + current.node + ", Looped.");
//                        for (Integer integer : path)
//                            safe[integer] = false;
//                    } else {
//                        visited[current.node] = true;
//                        checked[current.node] = true;
//                        path.add(current.node);
//                        for (int to : graph[current.node]) {
//                            stack.push(new StackNode(to, current.pathLength + 1));
//                        }
//                    }
//                }
//            }
//        }
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < safe.length; i++)
//            if (safe[i])
//                res.add(i);
//
//        return res;
//    }
//}
