import java.util.Scanner;

public class Solution {

    public static void insertIntoSorted(int[] ar) {
        if (ar.length <= 1) printArray(ar);

        int temp = ar[ar.length - 1];

        for (int f1 = ar.length - 2; ; f1--) {
            ar[f1 + 1] = ar[f1];
            printArray(ar);
            if (f1 == 0 || ar[f1 - 1] <= temp) {
                ar[f1] = temp;
                printArray(ar);
                break;
            }
        }
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.print("\n");
    }


}
