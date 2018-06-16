package leetcode.path_sum_ii_0113;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    TreeNode input01;

    @Before
    public void before() {
        solution = new Solution();
        input01 = new TreeNode(5);
        input01.left = new TreeNode(4);
        input01.right = new TreeNode(8);
        input01.left.left = new TreeNode(11);
        input01.right.left = new TreeNode(13);
        input01.right.right = new TreeNode(4);
        input01.left.left.left = new TreeNode(7);
        input01.left.left.right = new TreeNode(2);
        input01.right.right.left = new TreeNode(5);
        input01.right.right.right = new TreeNode(1);
    }

    @Test
    public void hasPathSum() {
        List<List<Integer>> rep = solution.pathSum(input01, 22);
        System.out.println(rep);
        assertEquals(2, rep.size());

    }
}