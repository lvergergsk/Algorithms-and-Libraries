import org.junit.Test;

import java.util.Arrays;

public class MinimalTreeTest {
    Integer[] array = new Integer[]{1, 5, 3, 2, 6, 5, 4, 57, 242, 26, 82, 5783, 793, 2, 1938};

    @Test
    public void createWithRecursion() {
        Arrays.sort(array);
        MinimalTree minimalTree = new MinimalTree();
        TreeNode<Integer> root = minimalTree.createWithRecursion(array);
    }

    @Test
    public void createWithoutRecursion() {
        Arrays.sort(array);
        MinimalTree minimalTree = new MinimalTree();
        TreeNode<Integer> root = minimalTree.createWithoutRecursion(array);
    }
}