package leetcode.lowest_common_ancestor_of_a_binary_tree_0236;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    TreeNode input01;

    @Before
    public void before() {
        solution = new Solution();
        input01 = new TreeNode(3);
        input01.left = new TreeNode(5);
        input01.right = new TreeNode(1);
        input01.left.left = new TreeNode(6);
        input01.left.right = new TreeNode(2);
        input01.right.left = new TreeNode(0);
        input01.right.right = new TreeNode(8);
        input01.left.right.left = new TreeNode(7);
        input01.left.right.right = new TreeNode(4);
    }

    @Test
    public void lowestCommonAncestor01() {
        TreeNode rep = solution.lowestCommonAncestor(input01, input01.left, input01.right);
        assertEquals(3, rep.val);
    }

    @Test
    public void lowestCommonAncestor02() {
        TreeNode rep = solution.lowestCommonAncestor(input01, input01.left, input01.left.right.right);
        assertEquals(5, rep.val);
    }
}