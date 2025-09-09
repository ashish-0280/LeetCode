class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;

        for (int day = 2; day <= n; day++) {
            for (int i = delay; i < forget; i++) {
                if (day - i > 0) {
                    dp[day] = (dp[day] + dp[day - i]) % MOD;
                }
            }
        }

        long res = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i > 0) res = (res + dp[i]) % MOD;
        }

        return (int) res;
    }
}
