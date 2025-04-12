class Solution {
    int dp[][];
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        dp = new int[satisfaction.length+1][satisfaction.length+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(satisfaction, 1, 0);
    }
    public int solve(int satisfaction[], int time, int idx){
        if(idx >= satisfaction.length){
            return 0;
        }
        if(dp[idx][time] != -1){
            return dp[idx][time];
        }
        int take = satisfaction[idx] * time + solve(satisfaction, time+1, idx+1);
        int notTake = solve(satisfaction, time, idx+1);
        return dp[idx][time] = Math.max(take, notTake);
    }
}