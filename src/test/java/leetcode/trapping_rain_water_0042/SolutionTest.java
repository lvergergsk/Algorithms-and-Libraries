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
      @Test
    public void rainWater1() {
        int[] testInput = new int[]{1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2};
        int[] rep=solution.rainWaterTwoPointer(testInput);
        System.out.println(Arrays.toString(rep));
    }

    @Test
    public void rainWater2() {
        int[] testInput = new int[]{2,1,1,1,2};
        int[] rep=solution.rainWaterTwoPointer(testInput);
        System.out.println(Arrays.toString(rep));
    }

}