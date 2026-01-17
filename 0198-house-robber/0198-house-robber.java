class Solution {
    Integer dp[];
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return solve(nums, 0);
    }
    public int solve(int nums[], int idx){
        if(idx >= nums.length) return 0;
        if(dp[idx] != null) return dp[idx];
        int include = nums[idx] + solve(nums, idx+2);
        int exclude = solve(nums, idx+1);
        return dp[idx] = Math.max(include, exclude);
    }
}