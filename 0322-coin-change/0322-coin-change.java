class Solution {
    Integer dp[][];
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length+1][amount+1];
        int ans = solve(coins, 0, amount);
        return ans == Integer.MAX_VALUE-10 ? -1 : ans;
    }
    public int solve(int coins[], int idx, int amount){
        if(amount == 0){
            return 0;
        }
        if(idx == coins.length || amount < 0){
            return Integer.MAX_VALUE-10;
        }
        if(dp[idx][amount] != null) return dp[idx][amount];
        int take = Integer.MAX_VALUE;
        if(amount >= coins[idx]){
            take = 1 + solve(coins, idx, amount-coins[idx]);
        }
        int notTake = solve(coins, idx+1, amount);
        return dp[idx][amount] = Math.min(take, notTake);
    }
}