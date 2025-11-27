class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long minPrefix[] = new long[k];

        for (int i = 0; i < k; i++) minPrefix[i] = Long.MAX_VALUE;
        minPrefix[0] = 0;

        long pref = 0;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            pref += nums[i];
            int mod = (i + 1) % k;

            if (minPrefix[mod] != Long.MAX_VALUE) {
                ans = Math.max(ans, pref - minPrefix[mod]);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], pref);
        }

        return ans;
    }
}
