class Solution {
    int n;
    Integer dp[][];
    public int maxSumDivThree(int[] nums) {
        this.n = nums.length;
        this.dp = new Integer[n][3];
        int ans = solve(nums, 0, 0);
        return (ans < 0) ? 0 : ans;
    }
    public int solve(int[] nums, int idx, int mod) {
        if (idx == nums.length) {
            return (mod == 0) ? 0 : Integer.MIN_VALUE;
        }
        if(dp[idx][mod] != null){
            return dp[idx][mod];
        }
        int include = nums[idx] + solve(nums, idx + 1, (mod + (nums[idx] % 3)) % 3);
        int exclude = solve(nums, idx + 1, mod);
        return dp[idx][mod] = Math.max(include, exclude);
    }
}