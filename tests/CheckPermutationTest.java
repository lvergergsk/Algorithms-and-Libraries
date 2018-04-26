import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.*;

public class CheckPermutationTest {

    @Test
    public void checkPermutation() {
        CheckPermutation checkPermutation=new CheckPermutation();
        assertEquals(true,checkPermutation.checkPermutation("abccc", "bccca"));
        assertEquals(false,checkPermutation.checkPermutation("abcdc", "bccca"));
        assertEquals(false,checkPermutation.checkPermutation("accc", "bccca"));

    }
}