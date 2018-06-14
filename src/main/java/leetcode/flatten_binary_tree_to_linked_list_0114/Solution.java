package leetcode.flatten_binary_tree_to_linked_list_0114;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

//  Definition for a binary tree node.
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

class Solution {
    LinkedList<TreeNode> getPreOrder(TreeNode root) {
        LinkedList<TreeNode> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            res.add(node);
        }

        return res;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> preOrder = this.getPreOrder(root);
        ListIterator<TreeNode> it = preOrder.listIterator(preOrder.size());

        TreeNode prevNode = it.previous();
        prevNode.left = null;
        prevNode.right = null;
        while (it.hasPrevious()) {
            TreeNode node = it.previous();
            node.left = null;
            node.right = prevNode;
            prevNode = node;
        }
    }
}