class Solution {
    Integer dp[][][];
    public int countNumbersWithUniqueDigits(int n) {
        dp = new Integer[n][2][1<<10];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("9");
        }
        String s = sb.toString();
        int mask = 0; int tight = 1; int idx = 0;
        return solve(s, idx, tight, mask);
    }
    public int solve(String s, int idx, int tight, int mask){
        if(idx == s.length()) return 1;
        if(dp[idx][tight][mask] != null) return dp[idx][tight][mask];
        int ans = 0;
        int limit = (tight == 1) ? s.charAt(0)-'0' : 9;
        for(int i=0; i<=limit; i++){
        int newTight = (tight == 1 && i==limit) ? 1 : 0;
            if(mask == 0 && limit == i){
                ans += solve(s, idx+1, newTight, 0);
            } else {
                if((mask & (1<<i)) == 0){
                    ans += solve(s, idx+1, newTight, mask | (1<<i));
                }
            }
        }
        return ans;
    }
}