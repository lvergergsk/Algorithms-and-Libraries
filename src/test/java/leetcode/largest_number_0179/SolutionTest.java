package leetcode.largest_number_0179;

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
    public void largestNumber01() {
        assertEquals("210", solution.largestNumber(new int[]{10, 2}));
    }

    @Test
    public void largestNumber02() {
        assertEquals("9534330", solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    public void largestNumber03() {
        assertEquals("999999999999999998999999997", solution.largestNumber(new int[]{999999998, 999999997, 999999999}));
    }

    @Test
    public void largestNumber04() {
        assertEquals("0", solution.largestNumber(new int[]{0, 0}));
    }
}