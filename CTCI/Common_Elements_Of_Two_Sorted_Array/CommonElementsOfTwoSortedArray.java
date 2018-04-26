import java.util.ArrayList;

public class CommonElementsOfTwoSortedArray {

    ArrayList<Integer> find(Integer[] arr1, Integer[] arr2) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ) {
            if (arr1[i] == arr2[j]) {
                res.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) j++;
            else i++;
        }
        return res;
    }


}
