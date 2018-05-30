// https://techdevguide.withgoogle.com/resources/compress-decompression/

public class CompressDecompression {
    String compress(String input) {
        String[][] dp = new String[input.length()][input.length()];

        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                String subStr = input.substring(i, j);
                System.out.println(subStr);
                for (int k=i;k<j;k++){

                }
            }
        }

        return null;
    }

    String decompression(String input) {

        return null;
    }

}
