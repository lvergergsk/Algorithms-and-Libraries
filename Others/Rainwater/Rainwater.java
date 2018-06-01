// TODO
// URL: https://techdevguide.withgoogle.com/resources/volume-of-water/
// Sample IN: [1,3,2,4,1,3,1,4,5,2,2,1,4,2,2]
// Sample OUT: [1,7,7]

// Think about:
// [1,0,1]
// [0,1,0]
// [1,0,2]
// [2,0,1]
// [1,0,2,0,1]
// [2,0,1,0,2]
// [3,0,2,0,1]
// [3,0,2,0,1,0,2,0,3]

public class Rainwater {
    private static final boolean DEV_MODE = false;

    int[] rainWaterTwoPointer(int[] arr) {
        int[] res = new int[arr.length];

        if (arr.length < 3) return res;

        int ptrl = 0;
        int levell = arr[ptrl];
        int ptrr = arr.length - 1;
        int levelr = arr[ptrr];
        while (ptrl < ptrr) {
            if (DEV_MODE) System.out.println("-----------------");
            if (DEV_MODE) System.out.println("ptrl: " + ptrl + ", ptrr: " + ptrr);
            if (DEV_MODE) System.out.println("arr[ptrl]: " + arr[ptrl] + ", arr[ptrr]: " + arr[ptrr]);
            if (DEV_MODE) System.out.println("levell: " + levell + ", levelr: " + levelr);

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
}
