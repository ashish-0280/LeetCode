class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        return solve(word1, word2, 0, 0, dp);
    }
    public int solve(String s1, String s2, int i, int j, int dp[][]){
        if(j >= s2.length()){
            return dp[i][j] = s1.length() - i;
        }
        if(i >= s1.length()){
            return dp[i][j] = s2.length() - j;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, s2, i+1, j+1, dp);
        }
        int replace = solve(s1, s2, i+1, j+1, dp);
        int delete = solve(s1, s2, i+1, j, dp);
        int insert = solve(s1, s2, i, j+1, dp);

        return dp[i][j] = Math.min(replace, Math.min(delete, insert))+1;
    }
}