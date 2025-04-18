class Solution {
    Integer dp[][];
    public int minPathSum(int[][] grid) {
        dp = new Integer[grid.length+1][grid[0].length+1];
        return solve(grid, 0, 0);
    }
    public int solve(int grid[][], int idx1, int idx2){
        if(idx1 == grid.length-1 && idx2 == grid[0].length-1){
            return grid[grid.length-1][grid[0].length-1];
        }
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        if(idx1 >= grid.length || idx2 >= grid[0].length){
            return 999999;
        }
        int down = grid[idx1][idx2] + solve(grid, idx1 + 1, idx2);
        int right = grid[idx1][idx2] + solve(grid, idx1, idx2 + 1);
        return dp[idx1][idx2] = Math.min(down, right);
    }
}