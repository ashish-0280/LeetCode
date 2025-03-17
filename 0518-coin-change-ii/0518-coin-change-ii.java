class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(coins, amount, coins.length-1, dp);
    }
    public int solve(int coins[], int amount, int idx, int dp[][]){
        if(amount == 0){
            return 1;
        }
        if(idx < 0){
            return 0;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        if(amount >= coins[idx]){
            int ans1 = solve(coins, amount-coins[idx], idx, dp);
            int ans2 = solve(coins, amount, idx-1, dp);
            dp[idx][amount] = ans1 + ans2;
        } else {
            dp[idx][amount] = solve(coins, amount, idx-1, dp);
        }
        return dp[idx][amount];
    }
}