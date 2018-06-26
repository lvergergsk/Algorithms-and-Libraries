package leetcode.similar_string_groups_0839;

//import java.util.Arrays;
import java.util.HashSet;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public int numSimilarGroups(String[] strs) {
        int[] group = new int[strs.length];

        for (int i = 0; i < group.length; i++) {
            group[i] = i;
        }

        for (int i = 0; i < strs.length; i++) {
            dfs(i, strs, group);
        }

//        LOGGER.info("grouping: " + Arrays.toString(group));

        return countDistinct(group);
    }

    private int countDistinct(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) if (!set.contains(i)) set.add(i);
        return set.size();
    }

    private boolean isSimilar(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int u = -1, v = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (u == -1) {
                    u = i;
                } else if (v == -1) {
                    v = i;
                    if (s1.charAt(u) != s2.charAt(v) || s1.charAt(v) != s2.charAt(u)) return false;
                } else return false;
            }
        }
        return true;
    }

    //    if group = 0, not grouped.
    private void dfs(int index, String[] strs, int[] group) {
        for (int i = 0; i < strs.length; i++) {
            if (group[index] != group[i] && isSimilar(strs[index], strs[i])) {
                group[i] = group[index];
//                LOGGER.info("dfs: " + index + " -> " + i + "\n" +
//                        "group = " + Arrays.toString(group));
                dfs(i, strs, group);
            }
        }

    }

}