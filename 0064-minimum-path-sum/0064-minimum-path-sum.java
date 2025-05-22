class Solution {
    Integer dp[][];
    public int minPathSum(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        dp = new Integer[m][n];
        return solve(grid, m-1, n-1);
    }
    public int solve(int grid[][], int i, int j){
        if(i<0 || j<0) return 400001;
        if(dp[i][j] != null) return dp[i][j];
        if(i==0 && j==0) return grid[i][j];
        int up = grid[i][j] + solve(grid, i-1, j);
        int left = grid[i][j] + solve(grid, i, j-1);
        return dp[i][j] = Math.min(up, left);
    }
}