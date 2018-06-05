package leetcode.swim_in_rising_water_0778;

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
    public void swimInWater1() {
        int res = solution.swimInWater(new int[][]{{0, 2}, {1, 3}});
        assertEquals(3, res);
    }

    @Test
    public void swimInWater2() {
        int res = solution.swimInWater(new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}});
        assertEquals(16, res);
    }

    @Test
    public void swimInWater3() {
        int res = solution.swimInWater(new int[][]{
                {0, 1, 2, 3, 4},
                {1, 1, 2, 3, 4},
                {2, 2, 2, 3, 4},
                {3, 3, 3, 3, 4},
                {4, 4, 4, 4, 4,}});
        assertEquals(4, res);
    }

    @Test
    public void swimInWater4() {
        int res = solution.swimInWater(new int[][]{
                {3, 2},
                {1, 0}
        });
        assertEquals(3, res);
    }
}