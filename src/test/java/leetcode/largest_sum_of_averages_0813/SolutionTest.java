package leetcode.largest_sum_of_averages_0813;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    private final double eps = 0.0001;

    @Before
    public void before() {
        this.solution = new Solution();
    }


    @Test
    public void largestSumOfAverages01() {
        double rep = solution.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3);
        assertEquals(20, rep, eps);
    }

    @Test
    public void largestSumOfAverages02() {
        double rep = solution.largestSumOfAverages(new int[]{4, 1, 7, 5, 6, 2, 3}, 4);
        assertEquals(18.16667, rep, eps);
    }
}