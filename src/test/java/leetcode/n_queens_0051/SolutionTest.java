package leetcode.n_queens_0051;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void solveNQueens01() {
        List<List<String>> rep = solution.solveNQueens(4);
        assertEquals(2, rep.size());
    }

    @Test
    public void solveNQueens02() {
        List<List<String>> rep= solution.solveNQueens(5);
        assertEquals(10,rep.size());
    }
}