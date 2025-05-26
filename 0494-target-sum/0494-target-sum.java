class Solution {
    Integer dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        dp = new Integer[nums.length][20001];
        return solve(nums, 0, 0, target);
    }
    public int solve(int nums[], int idx, int sum, int target){
        if(idx == nums.length){
            return sum==target ? 1 : 0;
        }
        if(dp[idx][sum+1001] != null) return dp[idx][sum+1001];
        int take = solve(nums, idx+1,  sum-nums[idx], target);
        int notTake = solve(nums, idx+1, sum + nums[idx], target);
        return dp[idx][sum+1001] = take + notTake;

    }
}