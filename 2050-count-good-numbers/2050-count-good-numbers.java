class Solution {
    static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long oddPositions = (n/2);
        long evenPositions = (n+1)/2;
        
        long ans1 = solve(4, oddPositions);
        long ans2 = solve(5, evenPositions);

        int ans = (int)((ans1 * ans2) % MOD);
        return ans;
    }
    public long solve(long base, long exp){
        long result = 1;
        while(exp > 0){
            if((exp & 1) == 1){
                result = (base * result)%MOD;
            }
            base = (base * base)%MOD;
            exp >>= 1;
        }
        return result;
    }
}