package leetcode.non_decreasing_array_0665;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void checkPossibility01() {
        boolean rep = solution.checkPossibility(new int[]{3, 2, 2});
        assertTrue(rep);
    }

    @Test
    public void checkPossibility02() {
        boolean rep = solution.checkPossibility(new int[]{4, 2, 3});
        assertTrue(rep);
    }

    @Test
    public void checkPossibility03() {
        boolean rep = solution.checkPossibility(new int[]{4, 2, 1});
        assertFalse(rep);
    }

    @Test
    public void checkPossibility04() {
        boolean rep = solution.checkPossibility(new int[]{2, 3, 3, 2, 4});
        assertTrue(rep);
    }

    @Test
    public void checkPossibility05() {
        boolean rep = solution.checkPossibility(new int[]{3, 2, 3});
        assertTrue(rep);
    }

    @Test
    public void checkPossibility06() {
        boolean rep = solution.checkPossibility(new int[]{2, 3, 6, 5, 6});
        assertTrue(rep);
    }
}