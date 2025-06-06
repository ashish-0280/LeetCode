class Solution {
    Integer dp[][][];
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        dp = new Integer[len+1][2][2];
        return solve(s, 0, 1, 0);
    }
    public int solve(String s, int idx, int tight, int prevBit){
        if(idx == s.length()){
            return 1;
        }
        int ans = 0;
        if(dp[idx][prevBit][tight] != null){
            return dp[idx][prevBit][tight];
        }
        int limit = (tight == 1) ? s.charAt(idx)-'0' : 1;
        for(int i=0; i<=limit; i++){
            if(prevBit == 1 && i == 1){
                continue;
            }
            int newTight = (i == limit && tight == 1) ? 1 : 0;
            ans += solve(s, idx+1, newTight, i);
        }
        return dp[idx][prevBit][tight] = ans;
    }
}