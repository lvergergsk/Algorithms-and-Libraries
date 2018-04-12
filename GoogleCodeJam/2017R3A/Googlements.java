import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Googlements {
    private static final boolean DEV_MODE = false;

    private HashSet<String> googlements;

    public Googlements(String googlement) {
        this.googlements = new HashSet<>();
        googlements.add(googlement);
        decayFrom(googlement);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();
            Googlements googlements = new Googlements(n);

            System.out.println("Case #" + i + ": " + (googlements.getNumOfPossiblePredecessor()));
        }
    }

    public HashSet<String> getGooglements() {
        return googlements;
    }

    int getNumOfPossiblePredecessor() {
        return googlements.size();
    }

    private void decayFrom(String googlement) {
        int sum = 0;
        int len = googlement.length();
        int[] nums = googlement.chars().map(Character::getNumericValue).toArray();
        for (int i : nums) sum += i;

        if (DEV_MODE) System.out.println("Current value: " + googlement);
        if (sum > len) return;

        String base = "";
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                base += Integer.toString(i + 1);
            }
        }
        while (base.length() < len) base += "0";

        if (DEV_MODE) System.out.println("Base: " + base);
        Permutation permutation = new Permutation(base.length(), 0);
        while (permutation.hasNext()) {
            int[] perm = permutation.next();
            StringBuilder temp = new StringBuilder(base);
            for (int i = 0; i < base.length(); i++)
                temp.setCharAt(i, base.charAt(perm[i]));
            String value = temp.toString();
            if (!googlements.contains(value)) {
                googlements.add(value);
                decayFrom(value);
            }
        }
    }

}

