import org.junit.Test;
import static org.junit.Assert.*;

public class CharInStringIsUniqueTest {

    @Test
    public void isUniqueCharsUsingBitArray() {
        CharInStringIsUnique charInStringIsUnique = new CharInStringIsUnique();
        System.out.println(charInStringIsUnique.isUniqueCharsUsingBitArray("a\u0081"));
        System.out.println(charInStringIsUnique.isUniqueCharsUsingBitArray("adz"));
    }

    @Test
    public  void isUniqueCharsUsingHashSet(){
        CharInStringIsUnique charInStringIsUnique=new CharInStringIsUnique();
        assertEquals(charInStringIsUnique.isUniqueCharUsingHashSet("abcc"),false);
        assertEquals(charInStringIsUnique.isUniqueCharUsingHashSet("abdeG"),true);
    }
}