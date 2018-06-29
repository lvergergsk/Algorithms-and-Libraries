package leetcode.race_car_0818;

import java.util.Arrays;
import java.util.logging.Logger;

class Solution {
    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public int racecar(int target) {
        return racecarAnalytical(target);
    }

    public int racecarAnalytical(int target) {
        int[] dp = new int[target + 1];
        return racecarAnalytical(target, dp);
    }

    private int racecarAnalytical(int t, int[] dp) {
        if (dp[t] > 0) return dp[t];
//        2 ^ (n - 1) <= target < 2 ^ n
        int n = (int) (Math.log(t) / Math.log(2)) + 1;
//        If n is just the correct num of step of acceleration.
//        |-------------(N)----------->T|
        if (1 << n == t + 1) dp[t] = n;
        else {
//            |-------------(N)------T----->|R
//                                  |T<-(M)-|
            dp[t] = racecarAnalytical((1 << n) - 1 - t, dp) + n + 1;

//            |-------------(N)------------>|          T
//                                          |---(M)--->T|
//            O(logN) because n prop to t
            for (int m = 0; m < n - 1; ++m)
                dp[t] = Math.min(dp[t], racecarAnalytical(t - (1 << (n - 1)) + (1 << m), dp) + n + m + 1);
        }
//        LOGGER.info(Arrays.toString(dp));
        return dp[t];
    }

    //O(N (logN)^2)
    public int racecarTopDown(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 1, dp.length, -1);
        return racecarTopDown(target, dp);
    }

    private int racecarTopDown(int i, int[] dp) {
//        i: target
//        dp[i]: minimum number of step to reach target i.
//        m=1->j=1
//        m=2->j=4-1=3=1+2
//        m=3->j=8-1=7=1+2+4
//        m=4->j=16-1=1+2+4+8
//        j: advancement of m consequent acceleration.
//        p: advancement of q consequent acceleration.
//        m + 1 + q + 1 + racecarTopDown(i - (j - p), dp)
        LOGGER.info("TOPDOWN: i = " + i + ", \ndp = " + Arrays.toString(dp));
        if (dp[i] >= 0) {
            return dp[i];
        }

        dp[i] = Integer.MAX_VALUE;

        int m = 1, j = 1;

//        Accelerate
        for (; j < i; j = (1 << ++m) - 1) {
//            logN
            for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                dp[i] = Math.min(dp[i], m + 1 + q + 1 + racecarTopDown(i - (j - p), dp));
                LOGGER.info("TOPDOWN: i = " + i + ", j = " + j + ", m = " + m + ", p = " + p + ", q = " + q +
                        ", \ndp = " + Arrays.toString(dp));
            }
        }

//        Reverse
        dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + racecarTopDown(j - i, dp)));

        return dp[i];
    }

    //O(N (logN)^2)
    public int racecarButtomUp(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;

            int m = 1, j = 1;

//            logN
            for (; j < i; j = (1 << ++m) - 1) {
//                logN
                for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
                }
            }

            dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + dp[j - i]));
        }

        return dp[target];
    }
}