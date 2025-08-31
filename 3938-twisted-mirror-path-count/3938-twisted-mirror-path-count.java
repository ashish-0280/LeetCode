class Solution {
    Integer dp[][][];
    int m, n; static int mod = 1000000007;
    public int uniquePaths(int[][] grid) {
        this.m = grid.length; this.n = grid[0].length;
        dp = new Integer[m][n][2];
        return solve(grid, 0, 0, 0); 
    }
    public int solve(int grid[][], int row, int col, int dir){
        if(row == m-1 && col == n-1) return 1;
        if(row < 0 || col < 0 || row >= m || col >= n){
            return 0;
        }
        if(dp[row][col][dir] != null) return dp[row][col][dir];
        long ways = 0;
        if(grid[row][col] == 1){
            if(dir == 0){
                ways = solve(grid, row+1, col, 1);
            } else {
                ways = solve(grid, row, col+1, 0);
            }
        } else {
            ways += solve(grid, row+1, col, 1);
            ways += solve(grid, row, col+1, 0);
        }
        return dp[row][col][dir] = (int)(ways % mod);
    }
}