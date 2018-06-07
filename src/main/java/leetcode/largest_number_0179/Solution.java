package leetcode.largest_number_0179;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private int compareConcat(Integer o1, Integer o2) {
        String o1o2 = o1.toString() + o2.toString();
        String o2o1 = o2.toString() + o1.toString();
        for (int i = 0; i < o1o2.length(); i++)
            if (o1o2.charAt(i) != o2o1.charAt(i)) return o2o1.charAt(i) - o1o2.charAt(i);

        return 0;
    }

    public String largestNumber(int[] nums) {
        List<Integer> numDup = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numDup.sort(this::compareConcat);
        return numDup.stream().map(Object::toString).collect(Collectors.joining("")).replaceFirst("^0+(?!$)","");
    }
}
