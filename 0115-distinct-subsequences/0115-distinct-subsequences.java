class Solution {
    public int numDistinct(String A, String B) {
        int m = A.length(); int n = B.length();
        int dp[][] = new int[m+1][n+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(A, B, m-1, n-1, dp);
    }
    public int solve(String A, String B, int i, int j, int dp[][]){
        if(j < 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(A.charAt(i) == B.charAt(j)){
            int ans1 = solve(A, B, i-1, j-1, dp);
            int ans2 = solve(A, B, i-1, j, dp);
            dp[i][j] = ans1 + ans2;
        } else {
            dp[i][j] = solve(A, B, i-1, j, dp);
        }
        return dp[i][j];
    }
}