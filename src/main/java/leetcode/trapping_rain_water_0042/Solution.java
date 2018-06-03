package leetcode.trapping_rain_water_0042;

import java.util.Arrays;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());


    int[] rainWaterTwoPointer(int[] arr) {
        int[] res = new int[arr.length];

        if (arr.length < 3) return res;

        int ptrl = 0;
        int levell = arr[ptrl];
        int ptrr = arr.length - 1;
        int levelr = arr[ptrr];
        while (ptrl < ptrr) {
//            LOGGER.info("ptrl = " + ptrl + ", ptrr = " + ptrr +
//                    "\n levell = " + levell + ", levelr = " + levelr +
//                    "\n arr[ptrl] = " + arr[ptrl] +
//                    "\n arr[ptrr] = " + arr[ptrr]);

            if (arr[ptrr] < arr[ptrl]) {
                ptrr--;
                if (arr[ptrr] < levelr)
                    res[ptrr] += levelr - arr[ptrr];
                else
                    levelr = arr[ptrr];
            } else {
                ptrl++;
                if (arr[ptrl] < levell)
                    res[ptrl] += levell - arr[ptrl];
                else
                    levell = arr[ptrl];
            }
        }
        return res;
    }

    public int trap(int[] height) {
        return Arrays.stream(rainWaterTwoPointer(height)).sum();
    }
}
