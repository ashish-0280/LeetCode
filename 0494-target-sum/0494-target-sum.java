class Solution {
    Integer dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        dp = new Integer[nums.length][20001];
        return solve(nums, target, 0);
    }
    public int solve(int nums[], int target, int idx){
        if(idx >= nums.length){
            return target == 0 ? 1 : 0;
        }
        if(target >= 0){
            if(dp[idx][target] != null){
                return dp[idx][target];
            }
        }
        int include = solve(nums, target-nums[idx], idx+1);
        int exclude = solve(nums, target+nums[idx], idx+1);
        if(target >= 0){
            dp[idx][target] = include + exclude;
        }
        return include + exclude;
    }
}