class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        int ans = solve(coins, amount, coins.length-1, dp);
        return ans == Integer.MAX_VALUE-1 ? -1 : ans;
    }
    public int solve(int coins[], int amount, int idx, int dp[][]){
        if(idx < 0){
            return Integer.MAX_VALUE-1;
        }
        if(amount == 0){
            return 0;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        if(amount >= coins[idx]){
            int ans1 = solve(coins, amount-coins[idx], idx, dp) + 1;
            int ans2 = solve(coins, amount, idx-1, dp);
            return dp[idx][amount] = Math.min(ans1, ans2);
        } else {
            return dp[idx][amount] = solve(coins, amount, idx-1, dp);
        }
    }
}