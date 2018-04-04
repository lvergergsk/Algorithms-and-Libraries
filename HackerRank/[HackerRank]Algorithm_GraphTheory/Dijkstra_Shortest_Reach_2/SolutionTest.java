import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void main01() throws Exception {
        String input = "1\n" +
                "20 54\n" +
                "1 7 45\n" +
                "2 14 15\n" +
                "3 7 29\n" +
                "4 1 48\n" +
                "5 1 66\n" +
                "6 7 17\n" +
                "7 14 15\n" +
                "8 14 43\n" +
                "9 1 27\n" +
                "10 1 33\n" +
                "11 14 64\n" +
                "12 14 27\n" +
                "13 7 66\n" +
                "14 7 54\n" +
                "15 14 56\n" +
                "16 7 21\n" +
                "17 1 20\n" +
                "18 1 34\n" +
                "19 7 52\n" +
                "20 14 14\n" +
                "9 14 9\n" +
                "15 1 39\n" +
                "12 1 24\n" +
                "9 1 16\n" +
                "1 2 33\n" +
                "18 1 46\n" +
                "9 1 28\n" +
                "15 14 3\n" +
                "12 1 27\n" +
                "1 2 5\n" +
                "15 1 34\n" +
                "1 2 28\n" +
                "9 7 16\n" +
                "3 7 23\n" +
                "9 7 21\n" +
                "9 14 19\n" +
                "3 1 20\n" +
                "3 1 5\n" +
                "12 14 19\n" +
                "3 14 2\n" +
                "12 1 46\n" +
                "3 14 5\n" +
                "9 14 44\n" +
                "6 14 26\n" +
                "9 14 16\n" +
                "9 14 34\n" +
                "6 7 42\n" +
                "3 14 27\n" +
                "1 7 9\n" +
                "1 7 41\n" +
                "15 14 19\n" +
                "12 7 13\n" +
                "3 7 10\n" +
                "1 7 2\n" +
                "17\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Dijkstra.main(null);

        String output = baos.toString();
        assertEquals("20 25 25 68 86 39 22 70 36 53 91 35 88 27 30 43 54 74 41\n", output);
    }

    @Test
    public void main02() throws Exception {
        String input = "1\n" +
                "7 12\n" +
                "1 2 4\n" +
                "1 3 3\n" +
                "1 5 7\n" +
                "2 3 6\n" +
                "2 4 5\n" +
                "3 4 11\n" +
                "3 5 8\n" +
                "4 5 2\n" +
                "4 6 2\n" +
                "4 7 10\n" +
                "5 7 5\n" +
                "6 7 3\n" +
                "1\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Dijkstra.main(null);

        String output = baos.toString();
        assertEquals("4 3 9 7 11 12\n", output);
    }
}