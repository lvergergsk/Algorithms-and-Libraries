import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        int l = arr.length;

//        Scanning window
        int i = 0;
        int j = 0;

        while (j < l) {
            int diff = arr[j] - arr[i];
            if (diff == k) {
//                j++ is also equivalent
                i++;
                res++;
            } else if (diff > k) i++;
            else j++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        in.close();
    }
}
