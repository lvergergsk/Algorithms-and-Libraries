import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static int[] maximumPerimeterTriangle(int[] l) {
        Integer[] edges = Arrays.stream(l).boxed().toArray(Integer[]::new);
        Arrays.sort(edges, Collections.reverseOrder());
        int i = 0;
        while (i < edges.length - 2 && edges[i] >= (edges[i + 1] + edges[i + 2])) i++;
        int[] res;
        if (i == edges.length - 2) {
            res = new int[1];
            res[0] = -1;
        } else {
            res = new int[3];
            res[0] = edges[i + 2];
            res[1] = edges[i + 1];
            res[2] = edges[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] l = new int[n];
        for (int l_i = 0; l_i < n; l_i++) {
            l[l_i] = in.nextInt();
        }
        int[] result = maximumPerimeterTriangle(l);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
