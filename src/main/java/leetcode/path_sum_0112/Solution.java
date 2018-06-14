package leetcode.path_sum_0112;


import java.util.Stack;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private class StackNode {
        final TreeNode treeNode;
        final int sum;

        StackNode(TreeNode treeNode, int sum) {
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        Stack<StackNode> stack = new Stack<>();

//        dfs
        stack.push(new StackNode(root, root.val));
        while (!stack.isEmpty()) {
            StackNode node = stack.pop();
            if (node.treeNode.right != null)
                stack.push(new StackNode(node.treeNode.right, node.sum + node.treeNode.right.val));
            if (node.treeNode.left != null)
                stack.push(new StackNode(node.treeNode.left, node.sum + node.treeNode.left.val));
            if (node.treeNode.right == null && node.treeNode.left == null && node.sum == sum) return true;
        }

        return false;
    }
}
