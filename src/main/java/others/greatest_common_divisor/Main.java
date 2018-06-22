package others.greatest_common_divisor;

class Main {
    int recursive(int p, int q) {
        if (q == 0) return p;
        else return recursive(q, p % q);
    }

    int euclidean(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    int binary(int p, int q) {
        if (q == 0) return p;
        if (p == 0) return q;

        // p and q even
        if ((p & 1) == 0 && (q & 1) == 0) return binary(p >> 1, q >> 1) << 1;

            // p is even, q is odd
        else if ((p & 1) == 0) return binary(p >> 1, q);

            // p is odd, q is even
        else if ((q & 1) == 0) return binary(p, q >> 1);

            // p and q odd, p >= q
        else if (p >= q) return binary((p - q) >> 1, q);

            // p and q odd, p < q
        else return binary(p, (q - p) >> 1);
    }

    //  Certifying algorithm
    //  Return array [d, a, b] such that d = gcd(p, q), ap + bq = d
   int[] extendedEuclidean(int p, int q) {
        if (q == 0)
            return new int[]{p, 1, 0};

        int[] val = extendedEuclidean(q, p % q);
        int d = val[0];
        int a = val[2];
        int b = val[1] - (p / q) * val[2];
        return new int[]{d, a, b};
    }

}
