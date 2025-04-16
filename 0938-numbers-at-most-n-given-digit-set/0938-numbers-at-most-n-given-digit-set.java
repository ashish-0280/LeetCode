class Solution {
    int cnt =0; Integer dp[][];
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        for (int len = 1; len < s.length(); len++) {
            cnt += Math.pow(digits.length, len);
        }
        dp = new Integer[s.length()+1][2];
        cnt += solve(s, 0, 1, digits);
        return cnt;
    }
    public int solve(String s, int idx, int tight, String digits[]){
        if(idx == s.length()){
            return 1;
        }
        if(dp[idx][tight] != null){
            return dp[idx][tight];
        }
        int limit = (tight == 1) ? s.charAt(idx)-'0' : 9;
        int ans = 0;
        for(int i=0; i<digits.length; i++){
            int d = Integer.parseInt(digits[i]);
            if(d > limit) break;
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            ans += solve(s, idx+1, newTight, digits);
        }
        return dp[idx][tight] = ans;
    }
}