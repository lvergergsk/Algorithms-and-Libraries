package leetcode.kth_smallest_element_in_a_sorted_matrix_0378;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution;

    @Before
    public void before() {
        this.solution = new Solution();
    }

    @Test
    public void kthSmallest01() {
        int[][] arrays = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        assertEquals(1, solution.kthSmallest(arrays, 1));
        assertEquals(5, solution.kthSmallest(arrays, 2));
        assertEquals(9, solution.kthSmallest(arrays, 3));
        assertEquals(10, solution.kthSmallest(arrays, 4));
        assertEquals(11, solution.kthSmallest(arrays, 5));
        assertEquals(12, solution.kthSmallest(arrays, 6));
        assertEquals(13, solution.kthSmallest(arrays, 7));
        assertEquals(13, solution.kthSmallest(arrays, 8));
        assertEquals(15, solution.kthSmallest(arrays, 9));
    }

    @Test
    public void kthSmallest02(){
        int[][] arrays=new int[][]{{3,5,7,10},{20},{15,19,31,33}};
        assertEquals(3, solution.kthSmallest(arrays,1));
        assertEquals(5, solution.kthSmallest(arrays,2));
        assertEquals(7, solution.kthSmallest(arrays,3));
        assertEquals(10, solution.kthSmallest(arrays,4));
        assertEquals(15, solution.kthSmallest(arrays,5));
        assertEquals(19, solution.kthSmallest(arrays,6));
        assertEquals(20, solution.kthSmallest(arrays,7));
        assertEquals(31, solution.kthSmallest(arrays,8));
        assertEquals(33, solution.kthSmallest(arrays,9));
    }

}