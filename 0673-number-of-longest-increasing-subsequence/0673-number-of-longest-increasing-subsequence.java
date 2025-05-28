class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for(int i=0; i<n; i++){
            for(int prev_idx=0; prev_idx<=i-1; prev_idx++){
                if(nums[prev_idx] < nums[i] && dp[i] < dp[prev_idx]+1){
                    dp[i] = dp[prev_idx] + 1;
                    cnt[i] = cnt[prev_idx];
                } else if(nums[prev_idx] < nums[i] && dp[i] == dp[prev_idx]+1){
                    cnt[i] = cnt[i] + cnt[prev_idx];
                }
            }
            max = Math.max(max, dp[i]);
        }
        int count = 0;
        for(int i=0; i<cnt.length; i++){
            if(dp[i] == max) count += cnt[i];
        }
        return count;
    }
}