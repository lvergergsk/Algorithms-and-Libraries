package leetcode.jump_game_ii_0045;

//import java.util.Arrays;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());


    //    Time = O (N^2), Time Limit Exceeded.
//    int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = 0;
//        for (int i = 1; i < nums.length; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < i; j++) {
//                if (j + nums[j] >= i) min = Math.min(min, dp[j] + 1);
//            }
//            if (min == Integer.MAX_VALUE) return -1;
//            else dp[i] = min;
//        }
//
//        LOGGER.info("dp = \n" + Arrays.toString(dp));
//
//        return dp[dp.length - 1];
//    }

//    O(N)
    int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;

        int step = 0;
        int startInclusive = 0;
        int endExclusive = 1;
        while (endExclusive < nums.length) {
            int nextFurestestReach = endExclusive - 1;
            for (int i = startInclusive; i < endExclusive; i++) {
                int reach = i + nums[i];
                nextFurestestReach = Integer.max(nextFurestestReach, reach);
//                LOGGER.info("i = " + i + ", nums[i] = " + nums[i] + ", reach = " + reach + ", nextFurestestReach = " + nextFurestestReach);
            }

            startInclusive = endExclusive;
            endExclusive = nextFurestestReach+1;
            step++;
//            LOGGER.info("startInclusive = " + startInclusive + ", endExclusive = " + endExclusive + ", step = " + step);
        }

        return step;
    }
}
