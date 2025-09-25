class Solution {
    Integer dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new Integer[n][n];
        return solve(triangle, 0, 0);
    }
    public int solve(List<List<Integer>> list, int prevIdx, int row){
        if(row == list.size()-1){
            return list.get(row).get(prevIdx);
        }
        if(dp[row][prevIdx] != null) return dp[row][prevIdx];
        int ans1 = list.get(row).get(prevIdx) + solve(list, prevIdx, row+1);
        int ans2 = list.get(row).get(prevIdx) + solve(list, prevIdx+1, row+1);
        return dp[row][prevIdx] = Math.min(ans1, ans2);
    }
}