class Solution {
    public boolean isSubsequence(String s, String t) {
        return lcs(s, t) == s.length();
    }
    public int lcs(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(s1, s2, m-1, n-1, dp);
    }
    public int solve(String s1, String s2, int m, int n, int dp[][]){
        if(m < 0 || n < 0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(s1.charAt(m) == s2.charAt(n)){
            return 1 + solve(s1, s2, m-1, n-1, dp);
        }
        int ans1 = solve(s1, s2, m-1, n, dp);
        int ans2 = solve(s1, s2, m, n-1, dp);
        return dp[m][n] = Math.max(ans1, ans2);
    }
}