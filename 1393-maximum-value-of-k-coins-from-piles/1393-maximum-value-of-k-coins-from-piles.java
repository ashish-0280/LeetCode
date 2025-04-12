class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n+1][k+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int coins = 0; coins <= k; coins++){
                int sum = 0;
                dp[i][coins] = dp[i-1][coins];
                for(int currCoins = 1; currCoins<=Math.min(coins, piles.get(i-1).size()); currCoins++){
                    sum += piles.get(i-1).get(currCoins-1);
                    dp[i][coins] = Math.max(dp[i][coins], sum + dp[i-1][coins-currCoins]);
                }
            }
        }
        return dp[n][k];
    }
}