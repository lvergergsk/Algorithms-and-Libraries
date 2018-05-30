import java.util.Stack;

public class MinimalTree {
    private static final boolean DEV_MODE = true;

    TreeNode<Integer> createWithoutRecursion(Integer[] ints) {
        Stack<StackElement<Integer>> stack = new Stack<>();
        Interval rootInterval = new Interval(0, ints.length);
        TreeNode<Integer> root = new TreeNode<>(ints[rootInterval.getMidPoint()]);
        stack.push(new StackElement<>(root, rootInterval));

        while (!stack.empty()) {
            StackElement<Integer> currentElement = stack.pop();
            Interval currentInterval = currentElement.interval;

            if (DEV_MODE)
                System.out.println(String.format("current (%d,%d), left (%d,%d), right (%d,%d)",
                        currentInterval.leftIncluded, currentInterval.rightExcluded,
                        currentInterval.leftIncluded, currentInterval.getMidPoint(),
                        currentInterval.getMidPoint() + 1, currentInterval.rightExcluded));

            Interval nextIntervalLeft = new Interval(currentInterval.leftIncluded, currentInterval.getMidPoint());
            if (!nextIntervalLeft.isEmpty()) {
                TreeNode<Integer> nextTreeNodeLeft = new TreeNode<>(ints[nextIntervalLeft.getMidPoint()]);
                currentElement.treeNode.left = nextTreeNodeLeft;
                StackElement<Integer> nextElementLeft = new StackElement<>(nextTreeNodeLeft, nextIntervalLeft);
                stack.push(nextElementLeft);
            }

            Interval nextIntervalRight = new Interval(currentInterval.getMidPoint() + 1, currentInterval.rightExcluded);
            if (!nextIntervalRight.isEmpty()) {
                TreeNode<Integer> nextTreeNodeRight = new TreeNode<>(ints[nextIntervalRight.getMidPoint()]);
                currentElement.treeNode.right = nextTreeNodeRight;
                StackElement<Integer> nextElementRight = new StackElement<>(nextTreeNodeRight, nextIntervalRight);
                stack.push(nextElementRight);
            }


        }

        return root;
    }

    TreeNode<Integer> createWithRecursion(Integer[] ints) {
        TreeNode<Integer> root = balancedInsert(ints, 0, ints.length);
        return root;
    }

    TreeNode<Integer> balancedInsert(Integer[] array, int leftIncluded, int rightExcluded) {
        System.out.println(String.format("(%d,%d)", leftIncluded, rightExcluded));
        if (rightExcluded - leftIncluded <= 0) return null;
        TreeNode<Integer> root = new TreeNode<>(array[(rightExcluded + leftIncluded) / 2]);
        root.left = balancedInsert(array, leftIncluded, (rightExcluded + leftIncluded) / 2);
        root.right = balancedInsert(array, ((rightExcluded + leftIncluded) / 2) + 1, rightExcluded);
        return root;
    }

    private class StackElement<T> {
        final TreeNode<T> treeNode;
        final Interval interval;

        private StackElement(TreeNode<T> treeNode, Interval interval) {
            this.treeNode = treeNode;
            this.interval = interval;
        }
    }

    private class Interval {
        final int leftIncluded;
        final int rightExcluded;

        Interval(int leftIncluded, int rightExcluded) {
            this.leftIncluded = leftIncluded;
            this.rightExcluded = rightExcluded;
        }

        boolean isEmpty() {
            return leftIncluded == rightExcluded;
        }

        int getMidPoint() {
            return (rightExcluded + leftIncluded) / 2;
        }
    }


}

class TreeNode<T> {
    TreeNode<T> left;
    TreeNode<T> right;
    T data;

    TreeNode(T data) {
        this.data = data;
    }
}