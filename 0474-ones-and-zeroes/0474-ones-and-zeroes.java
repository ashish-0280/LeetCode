class Solution {
    Integer dp[][][];
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length][m+101][n+101];
        return solve(strs, 0, m, n);
    }
    public int solve(String strs[], int idx, int m, int n){
        if(idx == strs.length){
            return 0;
        }
        if(dp[idx][m+100][n+100] != null) return dp[idx][m+100][n+100];
        int count[] = countZeroesOnes(strs[idx]);
        int include = 0;
        if(m >= count[0] && n >= count[1]){
            include = 1 + solve(strs, idx+1, m-count[0], n-count[1]);
        }
        int exclude = solve(strs, idx+1, m, n);
        return dp[idx][m+100][n+100] = Math.max(include, exclude);
    }
    public int[] countZeroesOnes(String s){
        int cnt[] = new int[2];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                cnt[0]++;
            } else {
                cnt[1]++;
            }
        }
        return cnt;
    }
}