class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; 
        long oddPositions = n / 2;        

        long pow5 = modPow(5, evenPositions, MOD);
        long pow4 = modPow(4, oddPositions, MOD);

        return (int)((pow5 * pow4) % MOD);
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}