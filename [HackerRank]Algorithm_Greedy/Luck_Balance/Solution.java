import java.util.*;

public class Solution {
    static public final boolean DEV_MODE = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int luck = 0;
        List<Integer> luckPoint = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            int Li = scanner.nextInt();
            int Ti = scanner.nextInt();
            if (Ti == 0) {
                luck += Li;
                continue;
            }
            luckPoint.add(Li);
        }
        Collections.sort(luckPoint, Collections.reverseOrder());
        if (DEV_MODE) for (int i : luckPoint) System.out.print(i + " ");
        if (DEV_MODE) System.out.println();
        for (int f0 = 0; f0 < luckPoint.size(); f0++) {
            if (f0 < K) luck += luckPoint.get(f0);
            else luck -= luckPoint.get(f0);
        }
        System.out.println(luck);
    }
}