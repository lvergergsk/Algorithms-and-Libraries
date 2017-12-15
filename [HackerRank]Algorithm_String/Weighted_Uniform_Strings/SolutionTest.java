import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void main01() throws Exception {
        String input = "aaa 5 0 1 2 3 4";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Solution.main(null);

        String output = baos.toString();
        assertEquals("Yes\r\nYes\r\nYes\r\nYes\r\nNo\r\n", output);
    }

    @Test
    public void main02() throws Exception {
        String input = "bbccaa 9 2 0 4 3 6 1 10 11 12";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Solution.main(null);

        String output = baos.toString();
        assertEquals("Yes\r\nYes\r\nYes\r\nYes\r\nYes\r\nYes\r\nNo\r\nNo\r\nNo\r\n", output);
    }


}