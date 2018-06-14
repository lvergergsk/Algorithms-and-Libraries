package leetcode.path_sum_0112;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    TreeNode input01;

    @Before
    public void before() {
        this.solution = new Solution();
        input01 = new TreeNode(5);
        input01.left = new TreeNode(4);
        input01.right = new TreeNode(8);
        input01.left.left = new TreeNode(11);
        input01.right.left = new TreeNode(13);
        input01.right.right = new TreeNode(4);
        input01.left.left.left = new TreeNode(7);
        input01.left.left.right = new TreeNode(2);
        input01.right.right.right = new TreeNode(1);
    }


    @Test
    public void hasPathSum01() {
        boolean rep = solution.hasPathSum(input01, 22);
        assertTrue(rep);
    }

    @Test
    public void hasPathSum02() {
        boolean rep = solution.hasPathSum(input01, 23);
        assertFalse(rep);
    }

    @Test
    public void hasPathSum03() {
        boolean rep = solution.hasPathSum(null, 1);
        assertFalse(rep);
    }
}