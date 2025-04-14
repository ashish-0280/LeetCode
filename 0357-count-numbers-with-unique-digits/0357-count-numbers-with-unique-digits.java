class Solution {
    Integer dp[][][];
    public int countNumbersWithUniqueDigits(int n) {
        String s = "";
        for(int i=0; i<n; i++){
            s += '9';
        }
        dp = new Integer[n][2][1<<10];
        return solve(s, 0, 1, 0);
    }
    public int solve(String s, int idx, int tight, int mask){
        if (idx == s.length()) {
            return 1; // valid number constructed
        }

        if (dp[idx][tight][mask] != null) return dp[idx][tight][mask];

        int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            // skip leading zeros: allow zero if nothing has started yet
            if (mask == 0 && d == 0) {
                ans += solve(s, idx + 1, newTight, 0);
            } else {
                if ((mask & (1 << d)) == 0) {
                    ans += solve(s, idx + 1, newTight, mask | (1 << d));
                }
            }
        }
        return dp[idx][tight][mask] = ans;
    }
}