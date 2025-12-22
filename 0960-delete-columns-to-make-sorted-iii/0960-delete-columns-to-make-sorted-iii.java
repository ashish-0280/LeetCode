class Solution {
    Integer dp[][];
    public int minDeletionSize(String[] strs) {
        int n = strs.length; int m = strs[0].length();
        dp = new Integer[m+1][m];
        int maxKeep = solve(strs, n, m, -1, 0);
        return m - maxKeep;
    }
    public int solve(String strs[], int n, int m, int prev, int curr){
        if(curr == m) return 0;
        if(dp[prev+1][curr] != null) return dp[prev+1][curr];
        int include = 0;
        if(prev == -1 || compare(strs, prev, curr, n)){
            include = 1 + solve(strs, n, m, curr, curr+1);
        }
        int exclude = solve(strs, n, m, prev, curr+1);
        return dp[prev+1][curr] = Math.max(include, exclude);
    }
    public boolean compare(String strs[], int prev, int curr, int n){
        for(int i=0; i<n; i++){
            if(strs[i].charAt(prev) > strs[i].charAt(curr)){
                return false;
            }
        }
        return true;
    }
}