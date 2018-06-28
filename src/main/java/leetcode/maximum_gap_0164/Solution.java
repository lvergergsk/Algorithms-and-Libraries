package leetcode.maximum_gap_0164;

//import java.util.Arrays;
//import java.util.logging.Logger;


// O(N)
// bucket sort, pigeonhole principle.
class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public int maximumGap(int[] nums) {
//        LOGGER.info("input = " + Arrays.toString(nums));
        if (nums == null || nums.length < 2) return 0;

//        Find min and max, O(N)
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
//        LOGGER.info("min = " + min + ", max = " + max);

        int bucketSize = (max - min) / nums.length;
        if (bucketSize == 0) bucketSize = 1;

        int bucketNumber = (max - min) / bucketSize + 1;
        int[] bucketsMin = new int[bucketNumber];
        int[] bucketsMax = new int[bucketNumber];

        for (int i = 0; i < bucketNumber; i++) {
            bucketsMin[i] = Integer.MAX_VALUE;
            bucketsMax[i] = Integer.MIN_VALUE;
        }

        for (int i : nums) {
            int index = (i - min) / bucketSize; // index of the right position in the buckets
            bucketsMin[index] = Math.min(i, bucketsMin[index]);
            bucketsMax[index] = Math.max(i, bucketsMax[index]);
        }

//        LOGGER.info("bucketSize = " + bucketSize + "\n" +
//                "bucketsMin = " + Arrays.toString(bucketsMin) + "\n" +
//                "bucketsMax = " + Arrays.toString(bucketsMax));

        int res = Integer.MIN_VALUE;
        int previousMax = bucketsMax[0];
        for (int i = 0; i < bucketNumber; i++) {
//            Test if the bucket is empty.
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE)
                continue;
            // min value minus the previous value is the current gap
            res = Math.max(res, bucketsMin[i] - previousMax);
            // update previous bucket value
            previousMax = bucketsMax[i];
        }
//        res = Math.max(res, max - previousMax); // updata the final max value gap

        return res;
    }
}