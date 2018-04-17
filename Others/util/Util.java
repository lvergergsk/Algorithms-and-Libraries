import java.util.ArrayList;

public class Util {

//    getAllCombination(){
//
//    }

    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n - 1);
    }

    public static String[][] permute() {
        ArrayList<String> res = new ArrayList<>();
        return (String[][]) res.toArray();
    }


    private static void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private static int[] appendArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i];

        for (int i = 0; i < arr2.length; i++)
            res[arr1.length + i] = arr2[i];

        return res;
    }

    private static int[] removeOfRange(int[] arr, int from, int to) {
        int[] res = new int[arr.length - (to - from)];
        for (int i = 0, j = 0; j < res.length; i++, j++) {
            while (i >= from && i < to) i++;
            res[j] = arr[i];
        }
        return res;
    }
}
