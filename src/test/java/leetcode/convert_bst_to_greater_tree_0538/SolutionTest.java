package leetcode.convert_bst_to_greater_tree_0538;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    TreeNode input01;

    @Before
    public void before() {
        solution = new Solution();
        input01 = new TreeNode(5);
        input01.left = new TreeNode(2);
        input01.right = new TreeNode(13);
    }

    @Test
    public void convertBST() {
        TreeNode rep = solution.convertBST(input01);
        assertEquals(18, rep.val);
        assertEquals(13, rep.right.val);
        assertEquals(20, rep.left.val);
    }
}