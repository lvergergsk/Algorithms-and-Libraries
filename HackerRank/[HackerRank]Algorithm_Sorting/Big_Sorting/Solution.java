import java.util.*;

class BigSorting implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
            return o1.length() < o2.length() ? -1 : 1;
        }

        for (int i = 0; i < o1.length(); i++) {
            if (o1.charAt(i) != o2.charAt(i)) {
                return Character.getNumericValue(o1.charAt(i)) < Character.getNumericValue(o2.charAt(i)) ?
                        -1 : 1;
            }
        }
        return 0;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];

        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            unsorted[unsorted_i] = in.next();
        }

        List<String> ans = new ArrayList<>(Arrays.asList(unsorted));
        Collections.sort(ans, new BigSorting());

        for (String i : ans) {
            System.out.println(i);
        }
    }
}
