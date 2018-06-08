package leetcode.kth_smallest_element_in_a_sorted_matrix_0378;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//import java.util.logging.Logger;


// NOTE: This solution is correct, but has got overhead.
// NOTE: This solution neither require vertically sorted,
// nor require the arrays having the same length.

// N: num of arrays, find the Kth smallest: O(N + K logN).
class Solution {

//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private class HeapElement implements Comparable<HeapElement> {
        final int row;
        final int col;
        final int val;

        HeapElement(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(HeapElement o) {
            return Integer.compare(this.val, o.val);
        }

        @Override
        public String toString() {
            return "HeapElement{" +
                    "row=" + row +
                    ", col=" + col +
                    ", val=" + val +
                    '}';
        }
    }

    int kthSmallest(int[][] matrix, int k) {

        List<HeapElement> temp = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            temp.add(new HeapElement(i, 0, matrix[i][0]));

        PriorityQueue<HeapElement> queue = new PriorityQueue<>(temp);

//        LOGGER.info("Initialization: " + queue.toString());

        for (int i = 0; i < k - 1; i++) {
            HeapElement element = queue.remove();
            if ((element.col + 1) < matrix[element.row].length)
                queue.add(new HeapElement(element.row, element.col + 1, matrix[element.row][element.col + 1]));
//            LOGGER.info("ADD: " + element.toString() +
//                    "\nQueue: " + queue.toString());
        }

        return queue.remove().val;
    }

}