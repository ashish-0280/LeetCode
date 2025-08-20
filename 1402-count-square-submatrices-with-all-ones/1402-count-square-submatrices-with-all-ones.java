class Solution {
    int[][] memo;
    int[][] matrix;
    int m, n;
    
    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += dfs(i, j);
            }
        }
        return total;
    }
    
    private int dfs(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (matrix[i][j] == 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        
            memo[i][j] = 1 + Math.min(
                Math.min(dfs(i-1, j), dfs(i, j-1)),
                dfs(i-1, j-1)
            );
        return memo[i][j];
    }
}
