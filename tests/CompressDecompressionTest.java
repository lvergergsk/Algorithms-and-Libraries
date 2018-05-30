import org.junit.Test;

import static org.junit.Assert.*;

public class CompressDecompressionTest {

    @Test
    public void compress() {
        CompressDecompression compressDecompression=new CompressDecompression();
        compressDecompression.compress("abcd");
    }
}