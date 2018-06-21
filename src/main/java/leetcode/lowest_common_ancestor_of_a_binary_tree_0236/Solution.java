package leetcode.lowest_common_ancestor_of_a_binary_tree_0236;

//import java.util.logging.Logger;

// Definition for a binary tree node.
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
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        LOGGER.info("Before recursion: Current node: " + (root == null ? "null" : root.toString()));
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        LOGGER.info("After recursion: Current node: " + root.toString() +
//                "left: " + (left==null?"null":left.toString()) + "right: " + (right==null?"null":right.toString()));
        return (left != null && right != null) ? root : (left != null ? left : right);
    }
}
