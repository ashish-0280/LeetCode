class Solution {
    Integer dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length];
        return Math.min(solve(cost, 1), solve(cost, 0));
    }
    public int solve(int cost[], int idx){
        if(idx >= cost.length) return 0;
        
        if(dp[idx] != null) return dp[idx];
        int choice1 = cost[idx] + solve(cost, idx+1);
        int choice2 = cost[idx] + solve(cost, idx+2);

        return dp[idx] = Math.min(choice1, choice2);
    }
}