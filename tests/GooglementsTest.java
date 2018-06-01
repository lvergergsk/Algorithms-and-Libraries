import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class GooglementsTest {

    @Test
    public void test1() {
        Googlements googlements=new Googlements("20");
        assertEquals(4,googlements.getNumOfPossiblePredecessor());
    }


    @Test
    public void test2() {
        Googlements googlements=new Googlements("1");
        assertEquals(1,googlements.getNumOfPossiblePredecessor());
    }

    @Test
    public void test3() {
        Googlements googlements=new Googlements("123");
        assertEquals(1,googlements.getNumOfPossiblePredecessor());
    }

    @Test
    public void test4() {
        Googlements googlements=new Googlements("4124");
        assertEquals(1,googlements.getNumOfPossiblePredecessor());
    }

    @Test
    public void test5() {
        Googlements googlements=new Googlements("01000");
        assertEquals(6356,googlements.getNumOfPossiblePredecessor());
    }

}