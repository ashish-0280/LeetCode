class Solution {
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length+1];
        Arrays.fill(dp, -1);
        return solve(days, costs, 0);
    }
    public int solve(int days[], int costs[], int idx){
        if(idx >= days.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        int next1 = getNextIndex(days, days[idx], idx);
        ans1 = costs[0] + solve(days, costs, next1);
        int next2 = getNextIndex(days, days[idx] + 6, idx);
        ans2 = costs[1] + solve(days, costs, next2);
        int next3 = getNextIndex(days, days[idx] + 29, idx);
        ans3 = costs[2] + solve(days, costs, next3);
        return dp[idx] = Math.min(ans1, Math.min(ans2, ans3));
    }
    public int getNextIndex(int days[], int day, int idx){
        int low = idx;
        int high = days.length-1; int result = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(days[mid] <= day){
                low = mid+1;
            } else {
                result = mid;
                high = mid-1;
            }
        }
        return result == -1 ? days.length : result;
    }
}