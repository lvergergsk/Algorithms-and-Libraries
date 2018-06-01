import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

//        n+1 because given natural number start from 1
//        0th element is not used for clarity
        int[] index = new int[n + 1];

//        read input and record index
//        arr is the actual natural numbers
//        index is the position of the natural numbers, i is at position index[i] of arr.
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
            index[arr[arr_i]] = arr_i;
        }

//        swap the largest element to left-most
//        then swap the remaining largest element to second left-most position, and so on
//        we know largest element (it is N) because input is first N natural number in unsorted order
//        index must also be updated
        for (int i = 0; i < n && k > 0; i++) {
//            if the first element is already the largest element, then just skip.
            if (arr[i] == n - i) {
                continue;
            }
//            if the first element is not the largest element, then exchange and update index.
//            note current largest element is the natural number n-i
            arr[index[n - i]] = arr[i];
            index[arr[i]] = index[n - i];
            arr[i] = n - i;
            index[n - i] = i;

//            reduce the maximum swap count
            k--;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i != arr.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
