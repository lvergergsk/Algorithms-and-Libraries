import java.util.Scanner;

public class Solution {

    public static boolean DEV_MODE = false;

    static int pylons(int k, int[] arr) {
        if (DEV_MODE) for (int i : arr) System.out.print(i + " ");
        if (DEV_MODE) System.out.println();
        int i = 0;
        int j = 0;
        int loc = -1;
        int minNumOfTower = 0;

        while (i < arr.length) {
//            At this point, i is set to be the first uncovered position.
//            if all position is covered then this loop will stop.
//            We build a new tower now, the position is still unknown at this point.
            minNumOfTower++;

            if (DEV_MODE) System.out.println("--------------------");
            if (DEV_MODE) System.out.println("num of tower: " + minNumOfTower);


//            Set j to be the furthest position next tower can be.
//            which is first uncovered position + k - 1
            j = i + k - 1;
//            To prevent j exceed possible range.
            if (j >= arr.length)
                j = arr.length - 1;
            if (DEV_MODE) System.out.println("j set to be: " + j);


//            try to set tower at j, if not possible decrease the distance.
            while (j > loc && arr[j] == 0)
                j--;

            if (DEV_MODE) System.out.println("j finally become: " + j);

//            if j become the same position of last tower, then it is impossible to cover all position.
            if (j <= loc)
                return -1;
//            if we successfully set the tower, then update the tower position.
            loc = j;

//            update i to be the last uncovered position.
            i = j + k;
            if (DEV_MODE) System.out.println("i is set to be: " + i);
            if (DEV_MODE) System.out.println("loc is set to be: " + loc);
        }
        return minNumOfTower;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int result = pylons(k, arr);
        System.out.println(result);
        in.close();
    }
}
