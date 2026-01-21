class Solution {
    Integer dp[];
    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return solve(s, 0);
    }
    public int solve(String s, int idx){
        if(idx >= s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;
        
        if(dp[idx] != null) return dp[idx];
        
        int choice1 = 0, choice2 = 0;
        String str1 = s.substring(idx, idx+1);
        choice1 += solve(s, idx+1);
        if(idx <= s.length() - 2){
            String str2 = s.substring(idx, idx+2);
            int n = Integer.parseInt(str2);
            if(n <= 26){
                choice2 += solve(s, idx+2);
            }
        }
        return dp[idx] = choice1 + choice2;
    }
}