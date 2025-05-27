class Solution {
    Integer dp[][];
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length][nums.length+1];
        return solve(nums, 0, -1);
    }
    public int solve(int arr[], int idx, int prev){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][prev+1] != null) return dp[idx][prev+1];
        int take = 0;
        if(prev == -1 || arr[prev] < arr[idx]){
            take = 1 + solve(arr, idx+1, idx);
        }
        int notTake = solve(arr, idx+1, prev);
    
        return dp[idx][prev+1] = Math.max(take, notTake);
    }
}