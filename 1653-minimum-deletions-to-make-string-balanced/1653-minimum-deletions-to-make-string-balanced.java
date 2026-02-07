class Solution {
    public int minimumDeletions(String s) {
        int dp[] = new int[s.length()+1];
        dp[0] = 0;
        int freq[] = new int[2];
        for(int i=1; i<=s.length(); i++){
            if(s.charAt(i-1) == 'a'){
                if(freq[1] > 0){
                    dp[i] = Math.min(dp[i-1] + 1, freq[1]);
                } else {
                    dp[i] = dp[i-1];
                }
                freq[0]++;
            } else {
                freq[1]++;
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }
}