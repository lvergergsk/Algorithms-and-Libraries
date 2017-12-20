import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer value=in.nextInt();
        int size=in.nextInt();
        int[] givenArray=new int[size];
        for (int f1=0;f1<size;f1++){
            givenArray[f1]=in.nextInt();
        }

        System.out.println(Arrays.binarySearch(givenArray,value));
    }
}