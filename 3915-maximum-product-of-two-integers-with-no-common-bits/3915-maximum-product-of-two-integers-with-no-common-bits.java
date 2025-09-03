class Solution {
    public long maxProduct(int[] nums) {
        int max_n = 0;
        for (int num : nums) {
            max_n = Math.max(max_n, num);
        }
        int msb = (int) (Math.log(max_n) / Math.log(2));
        int max_mask = (1 << (msb + 1)) - 1;
        int[] dp = new int[max_mask + 1];
        for (int x : nums) {
            dp[x] = x;
        }
        for (int b = 0; b <= msb; ++b) {
            for (int mask = 0; mask <= max_mask; ++mask) {
                if ((mask & (1 << b)) > 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << b)]);
                }
            }
        }
        long ans = 0;
        for (int n : nums) {
            ans = Math.max(ans, (long) n * dp[max_mask ^ n]);
        }
        return ans;
    }
}