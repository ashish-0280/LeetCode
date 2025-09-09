class Solution {
    int MOD = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        long[] dp = new long[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = delay; j < forget; j++) {
                if (i - j > 0) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= n; i++) {
            if (i >= n-forget+1) ans = (ans + dp[i]) % MOD;
        }

        return (int) ans;
    }
}
