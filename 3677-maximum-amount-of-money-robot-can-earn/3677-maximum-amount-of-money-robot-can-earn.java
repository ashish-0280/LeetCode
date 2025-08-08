class Solution {
    Integer[][][] dp;
    
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        dp = new Integer[m][n][3];
        
        int result = solve(coins, 0, 0, 2);
        
        if (result <= Integer.MIN_VALUE / 2) {
            return -1;
        }
        
        return result;
    }
    
    public int solve(int[][] coins, int i, int j, int k) {
        int m = coins.length;
        int n = coins[0].length;
        
        if (i >= m || j >= n) {
            return Integer.MIN_VALUE / 2;
        }
        
        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && k > 0) {
                return 0;
            } else {
                return coins[i][j];
            }
        }
        
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        
        int ans;
        
        int valueWithCoin = coins[i][j] + Math.max(solve(coins, i + 1, j, k), solve(coins, i, j + 1, k));
        
        if (coins[i][j] < 0 && k > 0) {
            int valueWithoutCoin = Math.max(solve(coins, i + 1, j, k - 1), solve(coins, i, j + 1, k - 1));
            ans = Math.max(valueWithCoin, valueWithoutCoin);
        } else {
            ans = valueWithCoin;
        }
        
        return dp[i][j][k] = ans;
    }
}