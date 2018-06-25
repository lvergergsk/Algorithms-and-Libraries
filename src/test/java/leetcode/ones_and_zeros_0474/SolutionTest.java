package leetcode.ones_and_zeros_0474;

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
    public void findMaxForm01() {
        int rep = solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        assertEquals(4, rep);
    }

    @Test
    public void findMaxForm02() {
        int rep = solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
        assertEquals(2, rep);
    }
}