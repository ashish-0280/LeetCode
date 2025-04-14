class Solution {
    Integer dp[][][];
    public int countDigitOne(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        dp = new Integer[len][2][len*10];
        return solve(str, 0, 1, 0);
    }
    public int solve(String s, int idx, int tight, int cnt){
        if(idx == s.length()){
            return cnt;
        }
        if(dp[idx][tight][cnt] != null) return dp[idx][tight][cnt];
        int limit = (tight == 1) ? s.charAt(idx)-'0' : 9;
        int ans = 0;
        for(int i=0; i<=limit; i++){
            int updateCnt = cnt + (i==1 ? 1 : 0);
            ans += solve(s, idx+1, (tight == 1 && i == limit) ? 1 : 0, updateCnt);
        }
        return dp[idx][tight][cnt] = ans;
    }
}