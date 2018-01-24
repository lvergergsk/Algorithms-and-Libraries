import java.util.Scanner;

public class Solution {
//    https://www.youtube.com/watch?v=niMjxNtiuu8
//    https://www.youtube.com/watch?v=ORaGSyewF9Q

    static String pokerNim(int[] pile) {
        if (pile.length == 0) return "Second";
//        the same as basic nim game, player who control the balance state wins.
        int xor = pile[0];
        for (int i = 1; i < pile.length; i++) {
            xor ^= pile[i];
        }
        return (xor == 0 ? "Second" : "First");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] c = new int[n];
            for(int c_i = 0; c_i < n; c_i++){
                c[c_i] = in.nextInt();
            }
            String result = pokerNim(c);
            System.out.println(result);
        }
        in.close();
    }
}
