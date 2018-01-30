import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static final boolean DEV_MODE = false;

    static int minNumOfBitToRepresent(int value) {
        int bit = 0;
        while (value > 0) {
            bit++;
            value >>= 1;
        }
        return bit;
    }

    static int maxValueCanBeRepresented(int numOfBit) {
        return (1 << numOfBit) - 1;
    }

    static ArrayList<Integer> getPrimeList(int upperLimit) {
//        false: is not prime, true: is prime.
        int primeListSize = upperLimit + 1;
        boolean[] primes = new boolean[primeListSize];

        Arrays.fill(primes, true);

//        0, 1 is not prime
        primes[0] = false;
        primes[1] = false;

//        ref: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
        for (int i = 2; i < primeListSize; i++)
            if (primes[i])
                for (int j = 2 * i; j < primeListSize; j += i)
                    primes[j] = false;

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < primes.length; i++) if (primes[i]) res.add(i);

        return res;
    }

    static int primeXor(int[] a) {
//        First, notice the fact that:
//        1. x^y=y^x
//        2. x^x=0 --> x^x^y=y

//        if you have four 1s then possible set is:
//        {},{1},{1,1}{1,1,1},{1,1,1,1}

//        let dp[i][j] be the number of possible multi-set using all given numbers within range [3500,3500+i] whose xor result is equal to j.

//        dp[i][j] consist of 2 part:
//        part 1 is about even set like {}, {1,1}, {1,1,1,1}. Number of even set is ((count[i] / 2) + 1).
//        because these sets xor together equals 0 and will not post any effect on xor result.
//        so you should add dp[i-1][j] * (number of even set) to dp[i][j]
//        part 2 is about odd sets like {1}, {1,1,1}. Number of odd set is ((count[i] + 1) / 2).
//        because these set will make the the result become (original_result ^ (i+3500)), where (i+3500) is the new number.
//        so you should add dp[i-1][j^(i+3500)] * (number of odd set) to dp[i][j] because j^(i+3500)^(i+3500)=j.

//        So the update rule should be:
//        dp[i][j] = (dp[i - 1][j] * ((count[i] /2) +1) + dp[i - 1][j ^ (i + 3500)] * ((count[i] + 1) / 2));

//        for initialization, if you only include first number, which is 3500, only possible xor result value is 3500 and 0
//        so you have to set dp[0][0] to (number of even set), and set dp[0][3500] to (number of odd set).
//        and set others to zero.

        // given constant.
        int modulo = 1000000007;

        // prepare constants.
        int lower = 3500;
        int upper = 4500;
        int numOfPossibleInput = upper - lower + 1;
        int maxXorValue = maxValueCanBeRepresented(minNumOfBitToRepresent(4500));
        int numberOfPossibleXorValue = maxXorValue + 1;

        ArrayList<Integer> primes = getPrimeList(maxXorValue);
        int[] count = new int[numOfPossibleInput];
        long[][] dp = new long[numOfPossibleInput][numberOfPossibleXorValue];

//        Since there are 1<n<pow(10,5) input, and input can only be 3500<=ai<=4500,
//        we count how much times does each input appear.
        for (int ai : a) count[ai - lower]++;

//        Initialization
        Arrays.fill(dp[0], 0);
        dp[0][0] = (count[0] + 2) / 2;
        dp[0][3500] = (count[0] + 1) / 2;
        if (DEV_MODE) {
            System.out.println("Initialization:");
            System.out.println("dp[0][0] = " + dp[0][0]);
            System.out.println("dp[0][3500] = " + dp[0][3500]);
        }

//        DP iterations
//        let dp[i][j] be the number of possible multi-set using all given numbers within range [3500,3500+i] whose xor result is equal to j.

//        start from i=1 becaues 0 is initalized, taking modulo to prevent overflow.
        for (int i = 1; i < numOfPossibleInput; i++)
            for (int j = 0; j < numberOfPossibleXorValue; j++) {
                int theNumber = 3500 + i;
                int numOfEvenSet = (count[i] / 2) + 1;
                int numOfOddSet = (count[i] + 1) / 2;
                long part1 = dp[i - 1][j] * numOfEvenSet;
                long part2 = dp[i - 1][j ^ theNumber] * numOfOddSet;
                dp[i][j] = (part1 + part2) % modulo;

            }

        int res = 0;
        for (int p : primes) {
            if (DEV_MODE && dp[numOfPossibleInput - 1][p] != 0)
                System.out.println(dp[numOfPossibleInput - 1][p] + " multi-set(s) for " + p + ".");
            res += dp[numOfPossibleInput - 1][p];
            res %= modulo;
        }


        return res % modulo;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            int result = primeXor(a);
            System.out.println(result);
        }
        in.close();
    }
}
