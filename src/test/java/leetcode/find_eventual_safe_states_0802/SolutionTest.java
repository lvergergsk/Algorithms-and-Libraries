package leetcode.find_eventual_safe_states_0802;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    int[][] graph01;

    @Before
    public void before() {
        solution = new Solution();
        graph01 = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
    }

    @Test
    public void eventualSafeNodes() {
        List<Integer> rep = solution.eventualSafeNodes(graph01);
        assertEquals(Arrays.asList(2, 4, 5, 6), rep);
    }
}