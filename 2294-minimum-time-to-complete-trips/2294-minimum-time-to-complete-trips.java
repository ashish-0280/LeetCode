class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long i = time[0];
        long j = (long)time[time.length-1] * totalTrips;
        long ans = (long)i*totalTrips;
        while(i<=j){
            long mid = (long)(i+j)/2;
            if(solve(mid, time, totalTrips)){
                ans = mid;
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return ans;
    }
    public boolean solve(long k, int nums[], int target){
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += (long)(k / (long)nums[i]);
            if(sum >= target){
                return true;
            }
        }
        return false;
    }
}