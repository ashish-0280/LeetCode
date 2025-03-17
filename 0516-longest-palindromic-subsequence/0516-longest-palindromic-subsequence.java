class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(s, 0, n-1, dp);
    }
    public int solve(String s, int m, int n, int dp[][]){
        if(m >= s.length() || n < 0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(s.charAt(m) == s.charAt(n)){
            return dp[m][n] = 1 + solve(s, m+1, n-1, dp);
        }
        int ans1 = solve(s, m+1, n, dp);
        int ans2 = solve(s, m, n-1, dp);
        return dp[m][n] = Math.max(ans1, ans2);
    }
}