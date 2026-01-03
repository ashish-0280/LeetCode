class Solution {
    int MOD = 1000000007;
    public int numOfWays(int n) {
        if(n == 0) return 0;
        long two = 6; long three = 6;
        n--;
        while(n > 0){
            long nextTwo = (3 * two + 2 * three) % MOD;
            three = (2 * two + 2 * three) % MOD;
            two = nextTwo;
            n--;
        }
        return (int)(two + three) % MOD;
    }
}