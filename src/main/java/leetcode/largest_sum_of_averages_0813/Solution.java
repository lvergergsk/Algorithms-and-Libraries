package leetcode.largest_sum_of_averages_0813;

//import java.util.Arrays;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public double largestSumOfAverages(int[] A, int K) {

        int N = A.length;
        double[] accumulate = new double[N + 1];
        double[] dp = new double[N];

        for (int i = 0; i < N; i++) accumulate[i + 1] = accumulate[i] + A[i];
//        LOGGER.info("accumulate: " + Arrays.toString(accumulate));

//        dp[i] is the average from i to N
        for (int i = 0; i < N; i++) dp[i] = (accumulate[N] - accumulate[i]) / (N - i);
//        LOGGER.info("dp: " + Arrays.toString(dp));

//        kth dp[i] is the highest value of average with k division.
        for (int k = 0; k < K - 1; k++) {
            for (int i = 0; i < N; i++)
                for (int j = i + 1; j < N; j++)
//                    Not divide, or divide into [i,j] and [j,N]
                    dp[i] = Math.max(dp[i], (accumulate[j] - accumulate[i]) / (j - i) + dp[j]);
//            LOGGER.info("dp: " + Arrays.toString(dp));
        }

        return dp[0];
    }
}
