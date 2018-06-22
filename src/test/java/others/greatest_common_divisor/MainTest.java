package others.greatest_common_divisor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    Main main;

    @Before
    public void before() {
        main = new Main();
    }

    @Test
    public void recursive01() {
        int rep = main.recursive(252, 105);
        assertEquals(21, rep);
    }

    @Test
    public void euclidean01() {
        int rep = main.euclidean(252, 105);
        assertEquals(21, rep);
    }

    @Test
    public void binary01() {
        int rep = main.binary(252, 105);
        assertEquals(21, rep);
    }

    @Test
    public void extendedEuclidean() {
        int[] rep = main.extendedEuclidean(252, 105);
        assertEquals(-2 * 252 + 5 * 105, 21);
        assertArrayEquals(new int[]{21, -2, 5}, rep);
    }
}