import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static final boolean DEV_MODE = false;

    public static void main(String[] args) {

//        input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        String[] binaryNumbers = new String[n];
        if (DEV_MODE) System.out.println("Binary Representation for first 5 numbers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            binaryNumbers[i] = String.format("%32s", Integer.toBinaryString(numbers[i])).replace(' ', '0');
            if (DEV_MODE && i < 5) System.out.print(numbers[i] + ": ");
            if (DEV_MODE && i < 5) System.out.println(binaryNumbers[i]);
        }

        // These two container hold indices.
        ArrayList<Integer> zero = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();

        for (int i = 0; i < 32; i++) {
            zero = new ArrayList<>();
            one = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (binaryNumbers[j].charAt(i) == '0') {
                    zero.add(j);
                } else {
                    one.add(j);
                }
            }
            if (zero.size() > 0 && one.size() > 0) {
                if (DEV_MODE) System.out.println("Size of group 0: " + zero.size());
                if (DEV_MODE) System.out.println("Size of group 1: " + one.size());
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : zero) {
            for (int j : one) {
                int value = numbers[i] ^ numbers[j];
                min = min < value ? min : value;
            }
        }

        if (min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);

    }
}