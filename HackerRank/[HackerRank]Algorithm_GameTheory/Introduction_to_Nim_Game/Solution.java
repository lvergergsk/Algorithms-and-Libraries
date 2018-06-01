import java.util.Scanner;

public class Solution {
//    https://www.youtube.com/watch?v=niMjxNtiuu8
//    https://www.youtube.com/watch?v=ORaGSyewF9Q

    static String nimGame(int[] pile) {
        if (pile.length == 0) return "Second";
//        we need to decomposite numbers into power of 2s
//        if piles are balanced (has even number of piles for each power of 2 numbers),
//        then Second player wins as the player has the control of balance.
//        If piles are unbalanced (has odd number of piles for each power of 2 numbers),
//        then First player wins as the player has control of balance.
        int xor = pile[0];
        for (int i = 1; i < pile.length; i++) {
            xor ^= pile[i];
        }
        return (xor == 0 ? "Second" : "First");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            int[] pile = new int[n];
            for (int pile_i = 0; pile_i < n; pile_i++) {
                pile[pile_i] = in.nextInt();
            }
            String result = nimGame(pile);
            System.out.println(result);
        }
        in.close();
    }
}
