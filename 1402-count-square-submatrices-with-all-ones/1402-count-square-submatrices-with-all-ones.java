class Solution {
    Integer dp[][];
    int matrix[][];
    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new Integer[m][n];
        
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += solve(i, j);
            }
        }
        return total;
    }
    
    private int solve(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (matrix[i][j] == 0) return 0;
        if (dp[i][j] != null) return dp[i][j];
        
        dp[i][j] = 1 + Math.min(Math.min(solve(i-1, j), solve(i, j-1)),solve(i-1, j-1));
        return dp[i][j];
    }
}
