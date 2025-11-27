class Solution {
    long MOD = 1000000007L;

    public int countEffective(int[] a) {
        int n = a.length;

        int OR = 0;
        for (int x : a) OR |= x;

        int B = 63 - Long.numberOfLeadingZeros(OR) + 1;

        int size = 1 << B;
        long[] dp = new long[size];

        for (int x : a) dp[x]++;

        for (int j = 1; j < size; j <<= 1) {
            for (int i = 0; i < size; i++) {
                if ((i & j) != 0) {
                    dp[i] += dp[i ^ j];
                }
            }
        }

        long[] p2 = new long[n + 1];
        p2[0] = 1;
        for (int i = 1; i <= n; i++) {
            p2[i] = (p2[i - 1] * 2) % MOD;
        }

        for (int i = 0; i < size; i++) {
            dp[i] = (p2[(int) dp[i]] - 1 + MOD) % MOD;
        }

        for (int j = 1; j < size; j <<= 1) {
            for (int i = 0; i < size; i++) {
                if ((i & j) != 0) {
                    dp[i] = (dp[i] - dp[i ^ j] + MOD) % MOD;
                }
            }
        }

        long res = 1;
        for (int i = 0; i < OR; i++) {
            res = (res + dp[i]) % MOD;
        }

        return (int) res;
    }
}
