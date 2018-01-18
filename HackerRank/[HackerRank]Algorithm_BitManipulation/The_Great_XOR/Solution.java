import java.util.Scanner;

public class Solution {

    static long theGreatXor(long x) {
        // Complete this function
        long result = 0;
        int bitPos = 0;
        while (x != 0) {
//            for example x = 1001100,
//            for zero bit such as second bit form LSB,
//            we can xor 10, 11.
//            that is for each 0 bit, we set corresponding bit of a to be 1,
//            (notice bits which is more siginificant than the 0 bit is set to be all zero)
//            so the result of xor must exceed x (0 xor 1 = 1 > 0)
//            then we add number of all combination of less siginificant bits,
//            because result is already garenteed to be greater than x.
            if ((x & 1) == 0) {
//                System.out.println(x + " & 1 = " + (x & 1));
                result += (1L << bitPos);
            }
            bitPos++;
            x >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }
}
