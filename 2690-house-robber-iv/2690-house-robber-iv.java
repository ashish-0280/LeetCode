class Solution {
    public int minCapability(int[] nums, int k) {
        int low = findMin(nums);
        int high = findMax(nums);
        while(low <= high){
            int mid = (low + high)/2;
            if(isAns(nums, k, mid)){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    public int findMax(int nums[]){
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(num, max);
        }
        return max;
    }
    public int findMin(int nums[]){
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            min = Math.min(num, min);
        }
        return min;
    }
    public boolean isAns(int nums[], int k, int n){
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= n){
                cnt++;
                i++;
            }
            if(cnt >= k){
                return true;
            }
        }
        return false;
    }
}