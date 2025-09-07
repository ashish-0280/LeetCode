class Solution {
    public int countBinaryPalindromes(long n) {
        if (n == 0) return 1;

        int bits = Long.toBinaryString(n).length();
        int total = 1;
        for (int L = 1; L < bits; L++) {
            int len = (L + 1) / 2 - 1;
            if (len >= 0) total += 1 << len;
        }

        int half = (bits + 1) / 2;
        long prefix = n >> (bits - half);

        String b = Long.toBinaryString(prefix);
        if (b.length() < half) {
            b = "0".repeat(half - b.length()) + b;
        }

        String candidateStr;
        if (bits % 2 == 0) {
            candidateStr = b + new StringBuilder(b).reverse();
        } else {
            candidateStr = b + new StringBuilder(b.substring(0, b.length() - 1)).reverse();
        }

        long candidate = Long.parseLong(candidateStr, 2);

        total += prefix - (1L << (half - 1));
        if (candidate <= n) total++;

        return total;
    }
}
