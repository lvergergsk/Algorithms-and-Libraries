import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class GooglementsLarge {
    public static void main(String[] args) {
//        InputStream inputStream;
//        try {
//            inputStream = new FileInputStream("taska.in");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        OutputStream outputStream;
//        try {
//            outputStream = new FileOutputStream("taska.out");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//        TaskA solver = new TaskA();
//        int testCount = Integer.parseInt(in.next());
//        for (int i = 1; i <= testCount; i++)
//            solver.solve(i, in, out);
//        out.close();
        TaskA taskA=new TaskA();
        taskA.solve(1,new InputReader(System.in),new PrintWriter(System.out));
    }

    static class TaskA {
        static Map<Integer, Integer>[] precalcForLength;

        static {
            precalc();
        }

        static void precalc() {
            int tenPow = 1;
            precalcForLength = new Map[10];
            for (int length = 1; length <= 9; length++) {
                long time = System.currentTimeMillis();
                Map<Integer, Integer> set = new HashMap<>();
                Map<Integer, Integer> set2 = new HashMap<>();
                tenPow *= 10;
                for (int i = 0; i < tenPow; i++) {
                    int value = decay(i, length);
                    if (value < 0) {
                        continue;
                    }
                    Integer have = set.get(value);
                    if (have == null) {
                        have = 0;
                    }
                    set.put(value, have + 1);
                }
                set2 = new HashMap<>(set);
                for (Map.Entry<Integer, Integer> entry : set.entrySet()) {
                    int key = entry.getKey();
                    int cnt = entry.getValue();
                    while (true) {
                        int next = decay(key, length);
                        if (next == key) {
                            break;
                        }
                        set2.put(next, cnt + set2.get(next));
                        key = next;
                    }
                }
                precalcForLength[length] = set2;
                time = System.currentTimeMillis() - time;
                System.err.println("time " + time + ", " + length + " " + set.size());
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.nextToken();
            int n = s.length();
            int intValue = 0;
            for (int i = 0; i < s.length(); i++) {
                intValue = intValue * 10 + s.charAt(i) - '0';
            }
            Integer answer = precalcForLength[s.length()].get(intValue);
            if (answer == null) {
                answer = 0;
            }
            if (decay(intValue, s.length()) != intValue) {
                answer++;
            }
            out.println("Case #" + testNumber + ": " + answer);
        }

        static int decay(int value, int length) {
            int[] cnt = new int[length + 1];
            for (int i = 0; i < length; i++) {
                if (value % 10 > length) {
                    return -1;
                }
                ++cnt[value % 10];
                value /= 10;
            }
            int answer = 0;
            for (int i = 0; i < length; i++) {
                answer *= 10;
                answer += cnt[i + 1];
            }
            return answer;
        }

    }

    private static class InputReader {
        public BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            return nextToken();
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

    }
}
