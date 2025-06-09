class Solution {
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return solve(s, wordDict, 0);
    }
    public boolean solve(String s, List<String> list, int idx){
        if(idx == s.length()) return true;
        if(dp[idx] != null){
            return dp[idx];
        }
        for(int i=idx+1; i<=s.length(); i++){
            String str = s.substring(idx, i);
            if(list.contains(str)){
                if(solve(s, list, i)) return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}