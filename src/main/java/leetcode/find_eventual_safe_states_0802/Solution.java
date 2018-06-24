package leetcode.find_eventual_safe_states_0802;

import java.util.*;
//import java.util.logging.Logger;

class Solution {
    List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
//        color record result
        int[] color = new int[N];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                res.add(i);
        return res;
    }

    // colors:
    //      0: Didn't check
    //      1: Checked, not safe
    //      2: Checked, safe.
    private boolean dfs(int node, int[] color, int[][] graph) {
//        color > 0, checked
        if (color[node] > 0)
//            if current node is checked, no need to check it again, just return previous result.
            return color[node] == 2;

//        Make current node checked:
        color[node] = 1;
//        Look at each edge:
        for (int edge : graph[node]) {
//            If the edge is link to safe node, just skip this link.
            if (color[edge] == 2)
                continue;
//            If the edge is link to unsafe node, return false.
//            If the edge is linked to unchecked node, conduct dfs.
            if (color[edge] == 1 || !dfs(edge, color, graph))
                return false;
        }

//        If reach here, the current node is safe.
        color[node] = 2;
        return true;
    }
}
