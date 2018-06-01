import org.junit.Test;

import java.util.Arrays;

public class RainwaterTest {

    @Test
    public void rainWater1() {
        Rainwater rainwater = new Rainwater();

        int[] testInput = new int[]{1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2};
        int[] solution=rainwater.rainWaterTwoPointer(testInput);
        System.out.println(Arrays.toString(solution));
    }

    @Test
    public void rainWater2() {
        Rainwater rainwater = new Rainwater();

        int[] testInput = new int[]{2,1,1,1,2};
        int[] solution=rainwater.rainWaterTwoPointer(testInput);
        System.out.println(Arrays.toString(solution));
    }

}