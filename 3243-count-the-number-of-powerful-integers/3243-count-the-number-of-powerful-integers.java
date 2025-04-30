class Solution {
    Long dp[][];
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String s1 = Long.toString(start - 1);
        String s2 = Long.toString(finish);
        int len = Math.max(s1.length(), s2.length());
        s1 = padLeftZeros(s1, len);
        s2 = padLeftZeros(s2, len);

        int suffixStart = len - s.length();
        if (suffixStart < 0) return 0;
        dp = new Long[len][2];
        long res1 = solve(s2, s, suffixStart, 0, 1, limit);
        dp = new Long[len][2];
        long res2 = solve(s1, s, suffixStart, 0, 1, limit);
        return res1 - res2;
    }

    private String padLeftZeros(String s, int n) {
        while (s.length() < n) s = "0" + s;
        return s;
    }
    public long solve(String s, String suffix, int suffixStart, int idx, int tight, int limit) {
        if (idx == s.length()) {
            return 1;
        }
        if(dp[idx][tight] != null){
            return dp[idx][tight];
        }
        long ans = 0;
        int lmt = tight == 1 ? s.charAt(idx) - '0' : limit;
        lmt = Math.min(lmt, limit);

        for (int d = 0; d <= lmt; d++) {
            if (idx >= suffixStart) {
                int sufIdx = idx - suffixStart;
                if (d != suffix.charAt(sufIdx) - '0') continue;
            }
            int newTight = (tight == 1 && d == s.charAt(idx)-'0') ? 1 : 0;
            ans += solve(s, suffix, suffixStart, idx + 1, newTight, limit);
        }

        return dp[idx][tight] = ans;
    }
}
