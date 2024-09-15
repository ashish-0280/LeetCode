class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<text1.length(); i++){
            for(int j=0; j<text2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return helper(text1, text2, 0, 0, dp);

    }
    public int helper(String s1, String s2, int i, int j, int dp[][]){
        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(s1, s2, i+1, j+1, dp)+1;
        }
        return dp[i][j] = Math.max(helper(s1, s2, i, j+1, dp), helper(s1, s2, i+1, j, dp));
    }
}