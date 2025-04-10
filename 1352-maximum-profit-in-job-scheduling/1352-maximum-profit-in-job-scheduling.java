class Solution {
    int dp[] = new int[50001];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.fill(dp, -1);
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        return solve(jobs, 0);
    }

    public int solve(int[][] jobs, int idx) {
        if (idx >= jobs.length) return 0;
        if(dp[idx] != -1){
            return dp[idx];
        }
        int next = getNextIndex(jobs, idx+1, jobs[idx][1]);
        int taken = jobs[idx][2] + solve(jobs, next);
        int notTaken = solve(jobs, idx+1);
        return dp[idx] = Math.max(taken, notTaken);
    }
    public int getNextIndex(int jobs[][], int i, int ele){
        int low = i;
        int high = jobs.length-1; int ans = jobs.length;
        while(low <= high){
            int mid = (low + high)/2;
            if(jobs[mid][0] < ele){
                low = mid + 1;
            } else {
                high = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
}
