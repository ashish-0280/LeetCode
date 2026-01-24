class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = nums[0] + nums[1]; int high = nums[n-1] + nums[n-2];
        int ans = high;
        while(low <= high){
            int mid = (low + high)/2;
            if(check(nums, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean check(int nums[], int target){
        int  n = nums.length;
        for(int i=0; i<n/2; i++){
            if(nums[i] + nums[n-i-1] > target) return false;
        }
        return true;
    }
}