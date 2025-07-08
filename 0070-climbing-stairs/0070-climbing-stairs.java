class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return climb(n, dp);
    }
    public int climb(int n, int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != -1) return dp[n];
        int way1 = climb(n-1, dp);
        int way2 = climb(n-2, dp);
        return dp[n] = way1 + way2;
    }
}