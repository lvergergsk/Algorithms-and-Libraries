import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromePermutationTest {

    @Test
    public void parlindromePermutation() {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        assertEquals(true, palindromePermutation.parlindromePermutation("ababbb"));
        assertEquals(true, palindromePermutation.parlindromePermutation("ababbbb"));
        assertEquals(false, palindromePermutation.parlindromePermutation("ababbbbc"));
    }
}