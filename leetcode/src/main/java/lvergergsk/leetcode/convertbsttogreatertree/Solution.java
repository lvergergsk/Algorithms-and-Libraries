package lvergergsk.leetcode.convertbsttogreatertree;

import java.util.Stack;
//import java.util.logging.Logger;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

/**
 * 0538: convert bst to greater tree
 */
class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

//        In-order traverse, reversed;
        int sum = 0;

        TreeNode treeNode = root;
        while (!stack.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.right;
            } else {
                treeNode = stack.pop();
//                Reversed In-order traverse, do stuff here:
                sum += treeNode.val;
                treeNode.val = sum;
//                done
                treeNode = treeNode.left;
            }

//            LOGGER.info(stack.toString());
        }

        return root;
    }
}
