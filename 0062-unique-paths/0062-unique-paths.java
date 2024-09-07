class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return unique(m-1, n-1, dp);
    }
    public int unique(int m, int n, int dp[][]){
        if(m < 0 || n < 0){
            return 0;
        } else if(m == 0 && n == 0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int path1 = unique(m, n-1, dp);
        int path2 = unique(m-1, n, dp);
        return dp[m][n] = path1 + path2;
    }
}