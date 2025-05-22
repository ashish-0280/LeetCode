class Solution {
    Integer dp[][];
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        return solve(m-1, n-1);
    }
    public int solve(int m, int n){
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n] != null) return dp[m][n];
        if(m == 0 && n == 0){
            return 1;
        }
        int ans = 0;
        ans +=  solve(m, n-1) + solve(m-1, n); 
        return dp[m][n] = ans;
    }
}