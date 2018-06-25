package leetcode.ones_and_zeros_0474;

// 0/1 Knapsack Problem
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
//        m: number of 0s
//        n: number of 1s
//        int[][][] dp = new int[strs.length][m+1][n+1];
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0, sLength = strs.length; i < sLength; i++) {
//            Count 0 and 1 of current string.
            int sM = 0;
            int sN = 0;
            for (char c : strs[i].toCharArray())
                if (c == '0') sM++;
                else if (c == '1') sN++;

//            The direction of for loop is fixed, because we need use value of previous step, and save the space.
//            Illustration of dp[j][k], P is previous step, C is current step, X is current pointer.
//            PPP      PPP      PPP      PXC
//            PPP  ->  PPP  ->  PXC  ->  CCC
//            PPP      PXC      CCC      CCC
//            It's Ok as long as left top side of X is P.
            for (int j = m; j >= sM; j--) {
                for (int k = n; k >= sN; k--) {
//                    LHS dp[j][k]: given S=s[0:i], M=j, N=k
//                    RHS dp[j][k]: previous dp[j][k], i.e. given S=s[0:i-1], M=j, N=k
//                    dp[j - sM][k - sN]: previous dp[j - sM][k - sN], i.e. given S=s[0:i-1], M=j-sM, N=k-sN
                    dp[j][k] = Integer.max(dp[j][k], dp[j - sM][k - sN] + 1);
                }
            }
        }

        return dp[m][n];
    }
}