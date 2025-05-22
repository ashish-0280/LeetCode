class Solution {
    Integer dp[][][];
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][n];
        return solve(grid, 0, 0, n-1, m, n);
    }
    public int solve(int grid[][], int i, int col1, int col2, int m, int n){
        if(i >= m || col1 < 0 || col2 < 0 || col1 >= n || col2 >= n){
            return 0;
        }
        if(dp[i][col1][col2] != null){
            return dp[i][col1][col2];
        }
        int result = 0;
        if(col1 == col2){
            result += grid[i][col1];
        } else {
            result += grid[i][col1] + grid[i][col2];
        }
        int max = 0;
        for(int p1=-1; p1<=1; p1++){
            for(int p2=-1; p2<=1; p2++){
                int nextCol1 = col1 + p1;
                int nextCol2 = col2 + p2;
                max = Math.max(max, solve(grid, i+1, nextCol1, nextCol2, m, n));
            }
        }
        result += max;
        return dp[i][col1][col2] = result;
    }
}