class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = -1; ans[1] = -1;
        int low = 0; int high = nums.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                ans[0] = floor(nums, target);
                ans[1] = ceil(nums, target);
                return ans;
            } else if(nums[mid] < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public int floor(int nums[], int target){
        int low = 0; int high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
    public int ceil(int nums[], int target){
        int low = 0; int high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] <= target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }
}