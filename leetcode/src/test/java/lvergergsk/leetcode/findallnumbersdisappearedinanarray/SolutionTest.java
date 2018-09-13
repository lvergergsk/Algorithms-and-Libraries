package lvergergsk.leetcode.findallnumbersdisappearedinanarray;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void findDisappearedNumbers01() {
        List<Integer> rep = solution.findDisappearedNumbers(new int[]{1, 3, 4, 4});
        assertEquals(Collections.singletonList(2), rep);
    }
}