class Solution {
    Long dp[][];
    public long maxAlternatingSum(int[] nums) {
        dp = new Long[nums.length+1][2];
        return solve(nums, 0, true);
    }
    public long solve(int nums[], int idx, boolean flag){
        if(idx >= nums.length){
            return 0;
        }
        int f = (flag) ? 1 : 0;
        if(dp[idx][f] != null) return dp[idx][f];
        long skip = solve(nums, idx+1, flag);
        int val = nums[idx];
        if(!flag) val = -val;
        long take = solve(nums, idx+1, !flag) + val;
        return dp[idx][f] = Math.max(take, skip);
    }
}