class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];
        for(int i=0; i<n-1; i++){
            arr1[i] = nums[i];
        }
        for(int i=1; i<n; i++){
            arr2[i-1] = nums[i];
        }
        int ans1 = solve(arr1, 0, dp);
        Arrays.fill(dp, -1);
        int ans2 = solve(arr2, 0, dp);
        return Math.max(ans1, ans2);
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