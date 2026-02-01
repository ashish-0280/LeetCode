class Solution {
    public int minimumK(int[] nums) {
        int low = 1; int high = 100000;
        int ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            long ops = solve(nums, mid);
            if(ops <= (long)mid * mid){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public long solve(int nums[], int k){
        long ops = 0; 
        for(int num: nums){
            ops += num/k;
            if(num % k != 0){
                ops += 1;
            }
        }
        return ops;
    }
}