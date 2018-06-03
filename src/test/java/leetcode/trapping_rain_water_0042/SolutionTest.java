package leetcode.trapping_rain_water_0042;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void rainWaterTwoPointer() {
        int[] rep = solution.rainWaterTwoPointer(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertArrayEquals(new int[]{0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0}, rep);
    }

    @Test
    public void trap() {
        int rep = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(6,rep);
    }
}