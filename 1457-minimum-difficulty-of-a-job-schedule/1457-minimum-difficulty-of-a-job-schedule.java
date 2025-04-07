class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d){
            return -1;
        }
        int dp[][] = new int[jobDifficulty.length+1][d+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(jobDifficulty, d, 0, dp);
    }
    public int solve(int nums[], int d, int idx, int dp[][]){
        if(d == 1){
            int maxD = nums[idx];
            for(int i=idx; i<nums.length; i++){
                maxD = Math.max(maxD, nums[i]);
            }
            return maxD;
        }
        if(dp[idx][d] != -1){
            return dp[idx][d];
        }
        int finalResult = Integer.MAX_VALUE;
        int maxD = nums[idx];
        for(int i=idx; i<=nums.length-d; i++){
            maxD = Math.max(maxD, nums[i]);
            int result = maxD + solve(nums, d-1, i+1, dp);
            finalResult = Math.min(result, finalResult);
        }
        return dp[idx][d] = finalResult;
    }
}