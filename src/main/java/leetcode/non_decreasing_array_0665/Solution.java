package leetcode.non_decreasing_array_0665;

//import java.util.Arrays;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    //    It is non-decreasing, not increasing.
//    Be aware the case of check whether series is increasing.
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 1) return true;

        int maxViolate = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i == 0) {
                    nums[i] = nums[i + 1];
                } else if (i == nums.length - 2) {
                    nums[i + 1] = nums[i];
                } else {
                    if (nums[i + 1] >= nums[i - 1]) nums[i] = nums[i - 1];
                    else nums[i + 1] = nums[i];
                }
                maxViolate--;
//                LOGGER.info("i = " + i + "\n nums: " + Arrays.toString(nums));
                if (maxViolate < 0) return false;
            }
        }
        return true;
    }
}
