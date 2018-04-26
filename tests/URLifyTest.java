import org.junit.Test;

public class URLifyTest {

    @Test
    public void urlify() {
        URLify urLify = new URLify();
        System.out.println(urLify.urlify("apple orange   "));
    }
}