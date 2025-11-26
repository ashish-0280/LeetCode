class Solution {
    Integer dp[][][];
    int n, m;
    int MOD = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m][k];
        return solve(grid, 0, 0, 0, k);
    }

    public int solve(int[][] grid, int row, int col, int mod, int k) {
        if (row >= n || col >= m) return 0;

        mod = (mod + grid[row][col]) % k;

        if (row == n - 1 && col == m - 1)
            return mod == 0 ? 1 : 0;

        if (dp[row][col][mod] != null)
            return dp[row][col][mod];

        int right = solve(grid, row, col + 1, mod, k) % MOD;
        int down = solve(grid, row + 1, col, mod, k) % MOD;

        return dp[row][col][mod] = (right + down) % MOD;
    }
}
