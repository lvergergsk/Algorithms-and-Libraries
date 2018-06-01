import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonElementsOfTwoSortedArrayTest {

    @Test
    public void find() {
        CommonElementsOfTwoSortedArray commonElementsOfTwoSortedArray = new CommonElementsOfTwoSortedArray();
        Integer[] arr1 = new Integer[]{1, 2, 6, 4, 2, 5, 2, 15, 6135};
        Integer[] arr2 = new Integer[]{63, 2, 4, 3, 1, 1, 89, 7, 3};
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        ArrayList<Integer> solution = commonElementsOfTwoSortedArray.find(arr1, arr2);
        for (Integer i : solution) System.out.print(i + " ");
        System.out.println();

    }
}