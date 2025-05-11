class Solution {
    Integer dp[][];
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));
        dp = new Integer[1001][2500];
        return solve(pairs, 0, -1001);
    }
    public int solve(int pairs[][], int idx, int prev){
        if(idx == pairs.length){
            return 0;
        }
        if(dp[idx][prev+1005] != null) return dp[idx][prev+1005];
        int skip = solve(pairs, idx+1, prev);
        int take = 0;
        if(prev < pairs[idx][0]){
            take = 1 + solve(pairs, idx+1, pairs[idx][1]);
        }
        return dp[idx][prev+1005] = Math.max(take, skip);
    }
}