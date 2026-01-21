class Solution {
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        dp = new Boolean[s.length()];
        for(String str: wordDict){
            set.add(str);
        }
        return solve(s, 0, set);
    }
    public boolean solve(String s, int idx, Set<String> set){
        if(idx >= s.length()){
            return true;
        }

        if(dp[idx] != null) return dp[idx];

        for(int i=idx; i<s.length(); i++){
            String str = s.substring(idx, i+1);
            if(set.contains(str)){
                if(solve(s, i+1, set)){
                    return dp[idx] = true;
                }
            }
        }
        return dp[idx] =  false;
    }
}