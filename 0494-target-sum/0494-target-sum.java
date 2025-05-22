class Solution {
    Integer[][] dp;
    int offset = 1000;

    public int findTargetSumWays(int[] nums, int target) {
        dp = new Integer[nums.length][2001];
        return solve(nums, 0, target);
    }

    public int solve(int[] nums, int idx, int target) {
        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }

        if (target + offset < 0 || target + offset > 2000) {
            return 0;
        }

        if (dp[idx][target + offset] != null) {
            return dp[idx][target + offset];
        }

        int add = solve(nums, idx + 1, target - nums[idx]);
        int subtract = solve(nums, idx + 1, target + nums[idx]);

        return dp[idx][target + offset] = add + subtract;
    }
}
