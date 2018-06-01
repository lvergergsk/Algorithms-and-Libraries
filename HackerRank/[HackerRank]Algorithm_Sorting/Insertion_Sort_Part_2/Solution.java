import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    static void printArray(ArrayList<Integer> arrayList) {
        for (Integer i : arrayList) System.out.print(i + " ");
        System.out.print('\n');
    }

    static void insertionSort2(int n, int[] arr) {
        // Complete this function
        if (arr.length == 1) return;

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        for (int i = 1; i < arrayList.size(); i++) {
            int j = i;
            while (j > 0 && arrayList.get(i) < arrayList.get(j - 1)) j--;
            int temp=arrayList.remove(i);
            arrayList.add(j,temp);
            printArray(arrayList);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        insertionSort2(n, arr);
        in.close();
    }
}
