class Solution {
    int events[][];
    int dp[][];
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        this.events = events;
        dp = new int[events.length][k+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return solve(0, k);
    }
    public int solve(int idx, int k){
        if(idx >= events.length || k==0){
            return 0;
        }
        if(dp[idx][k] != -1){
            return dp[idx][k];
        }
        int exclude = solve(idx+1, k);
        int nextIndex = findIndex(idx);
        int include = events[idx][2] + solve(nextIndex, k-1);
        return dp[idx][k] = Math.max(include, exclude);
    }
    public int findIndex(int idx){
        int endDay = events[idx][1];
        int i=0; int j=events.length-1; int ans = j+1;
        while(i<=j){
            int mid = (i+j)/2;
            if(events[mid][0] > endDay){
                ans = mid;
                j = mid-1;
            } else {
                i=mid+1;
            }
        }
        return ans;
    }
}