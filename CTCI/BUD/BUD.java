// Bottlenecks, Unnecessary work, Duplicated work.

import java.util.ArrayList;
import java.util.HashMap;

public class BUD {
    public static void main(String[] args) {
        BUD bud = new BUD();
//        bud.bruteForce();
        System.out.println(bud.bud(200).size());
        System.out.println(bud.bruteForce(200).size());
    }

    //    find a^3+b^3=c^3+d^3
//    a,b,c,d < 1000
    ArrayList<Tuple4<Integer>> bruteForce(int n) {
        ArrayList<Tuple4<Integer>> res = new ArrayList<>();
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3))
                            res.add(new Tuple4<>(a, b, c, d));
                    }
                }
            }
        }
        return res;
    }

    ArrayList<Tuple4<Integer>> bud(int n) {
        ArrayList<Tuple4<Integer>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Tuple2<Integer>>> hashMap = new HashMap<>();
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int v = a + b;
                if (!hashMap.containsKey(v)) hashMap.put(v, new ArrayList<>());
                hashMap.get(v).add(new Tuple2<>(a, b));
            }
        }

        for (ArrayList<Tuple2<Integer>> v : hashMap.values()) {
            for (Tuple2<Integer> t1 : v) {
                for (Tuple2<Integer> t2 : v) {
                    res.add(new Tuple4<>(t1.v1, t1.v2, t2.v1, t2.v2));
                }
            }
        }
        return res;
    }

    class Tuple2<T> {
        final T v1;
        final T v2;

        Tuple2(T v1, T v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    class Tuple4<T> {
        final T v1;
        final T v2;
        final T v3;
        final T v4;

        public Tuple4(T v1, T v2, T v3, T v4) {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
            this.v4 = v4;
        }
    }
}
