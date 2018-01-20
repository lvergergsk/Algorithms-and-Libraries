import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static boolean DEV_MODE = false;

    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);

//        total number of points need to be covered.
        int numOfPoint = x.length;

//        repetitively finding first uncovered point
//        and furthest position a tower can be from this point.
//        when the first uncovered point exceed the index,
//        it means all points is covered.
        int firstUncovered = 0;
        int minNumOfTower = 0;
        while (firstUncovered < numOfPoint) {
            minNumOfTower++;
            int towerPosition = firstUncovered;
            int furthestPos = x[firstUncovered] + k;
            while (towerPosition < numOfPoint - 1 && x[towerPosition + 1] <= furthestPos)
                towerPosition++;
            firstUncovered = towerPosition;
            while (firstUncovered < numOfPoint && x[firstUncovered] <= x[towerPosition] + k)
                firstUncovered++;
            if (DEV_MODE)
                System.out.println("Tower position: " + x[towerPosition] + "; " +
                        "First uncoverd: " + (firstUncovered < x.length ? x[firstUncovered] : "Out of Range"));
        }
        return minNumOfTower;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int x_i = 0; x_i < n; x_i++) {
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
}