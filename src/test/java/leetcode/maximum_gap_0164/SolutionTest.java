package leetcode.maximum_gap_0164;

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
    public void maximumGap01() {
        int rep = solution.maximumGap(new int[]{3, 6, 9, 1});
        assertEquals(3, rep);
    }

    @Test
    public void maximumGap02() {
        int rep = solution.maximumGap(new int[]{10});
        assertEquals(0, rep);
    }

    @Test
    public void maximumGap03() {
        int rep = solution.maximumGap(new int[]{1,1,1,1});
        assertEquals(0, rep);
    }
}