package leetcode.jump_game_0055;

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
    public void canJump01() {
        boolean res = solution.canJump(new int[]{2, 3, 1, 1, 4});
        assertTrue(res);
    }

    @Test
    public void canJump02() {
        boolean res = solution.canJump(new int[]{3, 2, 1, 0, 4});
        assertFalse(res);
    }
}