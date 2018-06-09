package leetcode.jump_game_ii_0045;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution;

    @Before
    public void before() {
        this.solution = new Solution();
    }

    @Test
    public void jump01() {
        int res = solution.jump(new int[]{2, 3, 1, 1, 4});
        assertEquals(2, res);
    }

    @Test
    public void jump02() {
        int res = solution.jump(new int[]{3, 2, 3, 2, 2, 2, 100, 0, 2, 2, 2, 2, 2, 2, 2, 2});
        assertEquals(4, res);

    }
}