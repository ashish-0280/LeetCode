class Solution {
    Integer dp[][];
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length+1][amount+1];
        return solve(coins, amount, 0);
    }
    public int solve(int coins[], int amount, int idx){
        if(amount == 0) return 1;
        if(idx == coins.length || amount < 0){
            return 0;
        }
        if(dp[idx][amount] != null) return dp[idx][amount];
        int take = 0;
        if(amount >= coins[idx]){
            take = solve(coins, amount-coins[idx], idx);
        }
        int notTake = solve(coins, amount, idx+1);
        return dp[idx][amount] = take + notTake;

    }
}