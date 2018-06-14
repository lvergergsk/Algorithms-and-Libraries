package leetcode.flatten_binary_tree_to_linked_list_0114;

import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;
    TreeNode input;

    @Before
    public void before() {
        this.solution = new Solution();
        this.input = new TreeNode(1);
        this.input.left = new TreeNode(2);
        this.input.left.left = new TreeNode(3);
        this.input.left.right = new TreeNode(4);
        this.input.right = new TreeNode(5);
        this.input.right.right = new TreeNode(6);

    }

    @Test
    public void flatten() {
        solution.flatten(input);
        assertEquals(1, input.val);
        assertEquals(2, input.right.val);
        assertEquals(3, input.right.right.val);
        assertEquals(4, input.right.right.right.val);
        assertEquals(5, input.right.right.right.right.val);
        assertEquals(6, input.right.right.right.right.right.val);
//        do {
//            System.out.println(input.val);
//            input=input.right;
//        }while (input!=null);
    }
}