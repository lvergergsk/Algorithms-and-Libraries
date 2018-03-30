// We have to paint n boards of length {A1, A2, .. An}.
// There are k painters available and each takes 1 unit time to paint 1 unit of board.
// The problem is to find the minimum time to get this job done under the constraints
// that any painter will only paint continuous sections of boards,
// say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
//
//        Examples:
//
//        Input : k = 2, A = {10, 10, 10, 10}
//        Output : 20.
//        Here we can divide the boards into 2
//        equal sized partitions, so each painter
//        gets 20 units of board and the total
//        time taken is 20.
//
//        Input : k = 2, A = {10, 20, 30, 40}
//        Output : 60.
//        Here we can divide first 3 boards for
//        one painter and the last board for
//        second painter.

// T(i,k-1):previous k-1 painters paint first ith boards.
// sum_{i+1}^n{A_j}: kth painter paint i+1 to n boards.
// max_{i=1...n}{T(i,k-1),sum_{i+1}^n{A_j}}: the actual time cost is the longer one
// T(n,k)=min{max_{i=1...n}{T(i,k-1),sum_{j=i+1}^n{A_j}}}: we need to find shortest time cost.
// T(n,k) is k painter painting first n boards.
// Init: T(1,k)=A_1 because if there is only one board, then the time cost is A_1.
// Init: T(n,1)=sum_{i=1}^n A_i because if there is only one painter, then he have paint all boards.

public class ThePaintersPartitionProblemSolution {
    private static final boolean DEV_MODE = true;

    public static void main(String[] args) {
        System.out.println(solve(2, new int[]{10, 20, 30, 40}));
    }

    static int getVolume(int[] arr, int from, int to) {
        if (to > from) return arr[to] - arr[from];
        else return 0;
    }

    static int solve(int K, int[] A) {
        int numOfRow = K;
        int numOfCol = A.length;
        int[][] dp = new int[numOfRow][numOfCol];

//        Base cases:
        for (int i = 0; i < numOfRow; i++) dp[i][0] = A[0];
        for (int j = 1; j < numOfCol; j++) dp[0][j] = dp[0][j - 1] + A[j];

        for (int i = 1; i < numOfRow; i++) {
            for (int j = 1; j < numOfCol; j++) {
                int minTime = Integer.MAX_VALUE;
                for (int k = 0; k <= j; k++) {

                    int time = Math.max(dp[0][k], getVolume(dp[0], k, j));
                    if (DEV_MODE)
                        System.out.println("time = " + time + " = min (" + dp[0][k] + "," + getVolume(dp[0], k, j) + ")");
                    minTime = minTime < time ? minTime : time;
                }
                dp[i][j] = minTime;
                if (DEV_MODE) System.out.println("dp(" + i + "," + j + ") = " + minTime);
            }
        }
        return dp[numOfRow - 1][numOfCol - 1];
    }
}
