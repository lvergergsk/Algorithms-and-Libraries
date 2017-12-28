import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void main01() throws Exception {
        String input = "5\n2 4 6 8 3";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Solution.main(null);

        String output = baos.toString();
        assertEquals("2 4 6 8 8 \n" +
                "2 4 6 6 8 \n" +
                "2 4 4 6 8 \n" +
                "2 3 4 6 8 \n", output);
    }

}