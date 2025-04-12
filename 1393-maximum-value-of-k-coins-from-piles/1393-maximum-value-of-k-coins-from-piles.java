class Solution {
    int dp[][];
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[piles.size()+1][k+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(piles, k, 0);
    }
    public int solve(List<List<Integer>> list, int k, int idx){
        if(idx >= list.size()){
            return 0;
        }
        if(dp[idx][k] != -1){
            return dp[idx][k];
        }
        int ans1 = 0;
        int ans2 = 0;
        ans1 = solve(list, k, idx+1); int sum = 0;
        int max = 0; 
        for(int i=0; i<Math.min(k, list.get(idx).size()); i++){
            sum += list.get(idx).get(i);
            ans2 = sum + solve(list, k-(i+1), idx+1);
            max = Math.max(max, ans2);
        }
        return dp[idx][k] = Math.max(ans1, max);
    }
}