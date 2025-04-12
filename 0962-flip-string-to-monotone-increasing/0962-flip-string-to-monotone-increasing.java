class Solution {
    int dp[][];
    public int minFlipsMonoIncr(String s) {
        dp = new int[s.length()+1][2];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(s, 0, '0');
    }
    public int solve (String s, int idx, char prev){
        if(idx == s.length()){
            return 0;
        }
        if(dp[idx][prev-'0'] != -1){
            return dp[idx][prev-'0'];
        }
        int flip = Integer.MAX_VALUE;
        int notFlip = Integer.MAX_VALUE;
        if(s.charAt(idx) == '0'){
            if(prev == '0'){
                flip = 1 + solve(s, idx+1, '1');
                notFlip = solve(s, idx+1, '0');
            } else {
                flip = 1 + solve(s, idx+1, '1');
            }
        } else {
            if(prev == '0'){
                flip = 1 + solve(s, idx+1, '0');
                notFlip = solve(s, idx+1, '1');
            } else {
                notFlip = solve(s, idx+1, '1');
            }
        }
        return dp[idx][prev-'0'] = Math.min(flip, notFlip);
    }
}