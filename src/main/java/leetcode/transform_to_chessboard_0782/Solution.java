package leetcode.transform_to_chessboard_0782;

//import java.util.logging.Logger;

class Solution {
//    CONDITION 1: In a valid chess board, there are 2 and only 2 kinds of rows and one is inverse to the other.
//    For example if there is a row 01010011 in the board, any other row must be either 01010011 or 10101100.
//    The same for columns.
//    A corollary is that, any rectangle inside the board with corners:
//    top left, top right, bottom left, bottom right must be 4 zeros or 2 ones 2 zeros or 4 zeros.
//
//    CONDITION 2: Another important property is that every row and column has half ones. Assume the board is N * N:
//    If N = 2*K, every row and every column has K ones and K zeros.
//    If N = 2*K + 1, every row and every column has K ones and K + 1 zeros or K + 1 ones and K zeros.

//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public int movesToChessboard(int[][] b) {
        int N = b.length, rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;

//        Check for CONDITION 1:
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j) {
//                LOGGER.info("i = " + i + ", j = " + j + ", \n" +
//                        "(00,i0,0j,ij) = (" + b[0][0] + "," + b[i][0] + "," + b[0][j] + "," + b[i][j] + "), \n" +
//                        "(00^i0^0j^ij) = " + (b[0][0] ^ b[i][0] ^ b[0][j] ^ b[i][j]));
                if ((b[0][0] ^ b[i][0] ^ b[0][j] ^ b[i][j]) == 1) return -1;
            }

        for (int i = 0; i < N; ++i) {
//            check for CONDITION 2 (step 1):
            rowSum += b[0][i];
            colSum += b[i][0];

//            rowSwap is the number of row need to be swapped, similar for colSwap.
//            We only need to look at first row and first column, since we ensure the board is valid.
//            Check whether row i need swap.
            if (b[i][0] == i % 2) rowSwap++;
//            Check whether column i need swap.
            if (b[0][i] == i % 2) colSwap++;
        }

//        check for CONDITION 2 (step 2):
        if (N / 2 > rowSum || rowSum > (N + 1) / 2) return -1;
        if (N / 2 > colSum || colSum > (N + 1) / 2) return -1;


//        Because it is "swap", we need even number for rowSwap and colSwap.
        if (N % 2 == 1) {
//            If N is odd, either colSwap or (N-colSwap) is even, we have no choice.
//            Similar for rowSwap.
            if (colSwap % 2 == 1) colSwap = N - colSwap;
            if (rowSwap % 2 == 1) rowSwap = N - rowSwap;
        } else {
//            If N is even, take minimum swap count.
            colSwap = Math.min(N - colSwap, colSwap);
            rowSwap = Math.min(N - rowSwap, rowSwap);
        }

//        The actual count for swap is sum or row and column need to swap, divided by 2.
        return (colSwap + rowSwap) / 2;
    }
}