class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }
    public int solve(int nums[], int idx, int dp[]){
        if(idx >= nums.length){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        int include = nums[idx] + solve(nums, idx+2, dp);
        int exclude = solve(nums, idx+1, dp);

        return dp[idx] = Math.max(include, exclude);
    }
}