import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void main01() throws Exception {
        String input = "4\n" +
                "4\n" +
                "1 1 0 0\n" +
                "0 1 1 0\n" +
                "0 0 1 0\n" +
                "1 0 0 0\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Solution.main(null);

        String output = baos.toString();
        assertEquals(5, Integer.parseInt(output));
    }

    @Test
    public void main02() throws Exception {
        String input = "7\n" +
                "6\n" +
                "1 1 1 1 0 1\n" +
                "1 0 0 0 0 1\n" +
                "1 0 0 0 0 1\n" +
                "1 0 1 1 0 1\n" +
                "1 0 0 0 0 1\n" +
                "1 0 0 0 0 1\n" +
                "1 1 1 1 1 1";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Solution.main(null);

        String output = baos.toString();
        assertEquals(21, Integer.parseInt(output));
    }

    @Test
    public void main03() throws Exception {
        String input = "7\n" +
                "6\n" +
                "1 1 1 1 1 1\n" +
                "1 0 1 0 0 1\n" +
                "1 0 0 1 1 1\n" +
                "1 1 0 0 0 1\n" +
                "1 0 1 0 0 1\n" +
                "1 0 1 0 0 1\n" +
                "1 1 1 1 1 1";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Solution.main(null);

        String output = baos.toString();
        assertEquals(28, Integer.parseInt(output));
    }

    @Test
    public void main04() throws Exception {
        String input = "7\n" +
                "5\n" +
                "1 1 1 0 1\n" +
                "0 0 1 0 0\n" +
                "1 1 0 1 0\n" +
                "0 1 1 0 0\n" +
                "0 0 0 0 0\n" +
                "0 1 0 0 0\n" +
                "0 0 1 1 0";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Solution.main(null);

        String output = baos.toString();
        assertEquals(9, Integer.parseInt(output));
    }


}