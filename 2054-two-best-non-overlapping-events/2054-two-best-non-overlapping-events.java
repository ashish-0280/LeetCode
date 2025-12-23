class Solution {
    Integer dp[][];
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        int n = events.length;
        dp = new Integer[n][3]; 
        return solve(events, 0, 0);
    }
    public int solve(int events[][], int idx, int cnt){
        if(idx == events.length || cnt == 2) return 0;
        if(dp[idx][cnt] != null) return dp[idx][cnt];

        int exclude = solve(events, idx+1, cnt);
        int nextIdx = compute(events, idx);
        int include = events[idx][2] + solve(events, nextIdx, cnt+1);
    
        return dp[idx][cnt] = Math.max(include, exclude);
    }
    public int compute(int events[][], int idx){
        int n = events.length;
        int low = idx+1; int high = n-1;
        int target = events[idx][1]; int ans = n;
        while(low <= high){
            int mid = (low+high)/2;
            if(events[mid][0] > target){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}