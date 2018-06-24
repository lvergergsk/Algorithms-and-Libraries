package leetcode.transform_to_chessboard_0782;

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
    public void movesToChessboard01() {
        int rep = solution.movesToChessboard(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}, {1, 0, 0, 1}});
        assertEquals(2, rep);
    }

}