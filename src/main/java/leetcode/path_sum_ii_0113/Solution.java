package leetcode.path_sum_ii_0113;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//import java.util.logging.Logger;
import java.util.stream.Collectors;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

//    @Override
//    public String toString() {
//        return "TreeNode{" +
//                "val=" + val +
//                '}';
//    }
}

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    class StackNode {
        final int sum;
        final TreeNode self;
        final TreeNode parent;

        StackNode(int sum, TreeNode self, TreeNode parent) {
            this.sum = sum;
            this.self = self;
            this.parent = parent;
        }
    }

    List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new LinkedList<>();

        Stack<StackNode> stack = new Stack<>();
        LinkedList<TreeNode> path = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

//        dfs
        stack.push(new StackNode(root.val, root, null));
        while (!stack.isEmpty()) {
            StackNode node = stack.pop();
            while (!path.isEmpty() && !path.get(path.size() - 1).equals(node.parent)) path.removeLast();

            path.addLast(node.self);

            if (node.self.right != null)
                stack.push(new StackNode(node.sum + node.self.right.val, node.self.right, node.self));
            if (node.self.left != null)
                stack.push(new StackNode(node.sum + node.self.left.val, node.self.left, node.self));
            if (node.self.right == null && node.self.left == null && node.sum == sum) {
                List<Integer> sol = path.stream().map(n -> n.val).collect(Collectors.toList());
                res.add(sol);
            }
//            LOGGER.info("Path: " + path.toString() + "\nSum: " + currentSum);
        }

        return res;

    }
}
