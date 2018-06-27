package others.combinatorial;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PermutationTest {
    Permutation permutation;
//@Before
//public void before(){
//    permutation=new Permutation()
//}

    @Test
    public void permutationTest01() {
        permutation = new Permutation(3, 0);
        int count=0;
        while (permutation.hasNext()) {
            count++;
            permutation.next();
//            System.out.println(Arrays.toString(permutation.next()));
        }
        assertEquals(6,count);
    }
}