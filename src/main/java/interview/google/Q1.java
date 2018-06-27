package interview.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Q1 {
    private HashMap<String, Integer> hashMap;

    private Q1() {
        hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("D", 1);
        hashMap.put("E", 2);
        hashMap.put("F", 3);
        hashMap.put("G", 1);
        hashMap.put("H", 2);
        hashMap.put("I", 3);
        hashMap.put("J", 1);
        hashMap.put("K", 2);
        hashMap.put("L", 3);
        hashMap.put("M", 1);
        hashMap.put("N", 2);
        hashMap.put("O", 3);
        hashMap.put("P", 1);
        hashMap.put("Q", 2);
        hashMap.put("R", 3);
        hashMap.put("S", 4);
        hashMap.put("T", 1);
        hashMap.put("U", 2);
        hashMap.put("V", 3);
        hashMap.put("W", 1);
        hashMap.put("X", 2);
        hashMap.put("Y", 3);
        hashMap.put("Z", 4);
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            System.out.println("Case #" + i + ": " + q1.getNumOfKeyStrike(line));
        }
    }

    int getNumOfKeyStrike(String str) {
        String[] characters = str.split("(?!^)");
        int res = 0;
        for (String s : characters) {
            res += hashMap.get(s);
        }
        return res;
    }
}
