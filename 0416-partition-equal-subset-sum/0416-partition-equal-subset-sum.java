class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        dp = new Boolean[nums.length][target+1];
        return solve(nums, target, 0);
    }
    public boolean solve(int nums[], int target, int idx){
        if(target == 0) return true;
        if(idx >= nums.length || target < 0){
            return false;
        }
        if(dp[idx][target] != null) return dp[idx][target];
        boolean include = solve(nums, target-nums[idx], idx+1);
        boolean exclude = solve(nums, target, idx+1);
        return dp[idx][target] = include || exclude;
    }
}