class Solution {
    public long mostPoints(int[][] questions) {
        long dp[] = new long[questions.length+1];
        Arrays.fill(dp, -1);
        return solve(questions, 0, dp);
    }
    public long solve(int[][] grid, int i, long dp[]){
        if(i >= grid.length){
            return 0l;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        long take = Long.valueOf(grid[i][0]) + solve(grid, i+grid[i][1]+1, dp);
        long skip = solve(grid, i+1, dp);

        return dp[i] = Math.max(take, skip);
    }
}