import org.junit.Test;

import java.util.ArrayList;

public class PermutatedStringContainmentTest {

    @Test
    public void solve() {
        String shorter = "abbc";
        String longer = "cbabadcbbabbcbabaabccbabc";
        PermutatedStringContainment permutatedStringContainment = new PermutatedStringContainment();
        ArrayList<Integer> solution = permutatedStringContainment.solve(shorter, longer);
        System.out.println(solution.size());
        for (int i : solution) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}