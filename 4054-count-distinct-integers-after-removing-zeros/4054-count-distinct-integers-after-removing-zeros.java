class Solution {
    String s;
    long[][] memo;

    public long countDistinct(long n) {
        this.s = Long.toString(n);
        int len = s.length();
        memo = new long[len + 1][2];
        for (int i = 0; i <= len; ++i) {
            memo[i][0] = -1L;
            memo[i][1] = -1L;
        }
        return solve(0, false, true);
    }

    private long solve(int idx, boolean isStarted, boolean isTight) {
        int len = s.length();
        if (idx == len) return isStarted ? 1L : 0L;

        int start = isStarted ? 1 : 0;
        if (!isTight && memo[idx][start] != -1L) return memo[idx][start];

        int limit = isTight ? s.charAt(idx) - '0' : 9;
        long ans = 0L;

        for (int d = 0; d <= limit; d++) {
            boolean newStart = isStarted || (d != 0);
            boolean newTight = isTight && (d == limit);

            if (d == 0) {
                if (!newStart) ans += solve(idx + 1, false, newTight);
            } else {
                ans += solve(idx + 1, true, newTight);
            }
        }

        if (!isTight) memo[idx][start] = ans;
        return ans;
    }
}