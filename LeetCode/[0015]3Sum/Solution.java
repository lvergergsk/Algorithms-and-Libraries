import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] num) {

        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < num.length - 2; i++) {
//            if the current number is the same as the previous number, then skip to next number.
//            for example: -5 -3 -3 1 2, current position is 2, which is "-3", then it will produce same result as previous step.
//            the result produced in previous step is -3, 1, 2, and it will repeat if we don't skip current step.

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
//                the triplet we are looking for must meet num[i]+lo+hi==0
//                we set lo to next number, and hi to last number and scan the right hand side of current number.
//                there may be multiple pair for same i
//                for example num[i]=-5 then lo and hi can be 1, 4 or 2, 3.

                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];

                while (lo < hi) {
//                    this loop continue until lo reach hi.
                    if (num[lo] + num[hi] == sum) {
//                        pc will reach here if the requirement of triplet is met.
//                        so the triplet will be added to solution set.
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));

//                        while here is just for skipping multiple occurrence of same number.
//                        It is not for performance, it is to maintain uniqueness of triplet.
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
//                        update to next combination of num[lo] and num[hi].
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum)
//                        if num[lo]+num[hi] is too small, increase smaller one.
                        lo++;
                    else
//                        otherwise, which means num[lo]+num[hi] is too big, decrease larger one.
                        hi--;
                }
            }
        }
        return res;
    }
}