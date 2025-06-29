class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = lowestIndex(nums, target);
        ans[1] = largestIndex(nums, target);
        return ans;
    }
    public int lowestIndex(int nums[], int target){
        int i=0; int j=nums.length-1;
        int ans = -1;
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                ans = mid;
                j = mid-1;
            } else if(nums[mid] > target){
                j = mid-1;
            } else {
                i= mid+1;
            }
        }
        return ans;
    }
    public int largestIndex(int nums[], int target){
        int i=0; int j=nums.length-1;
        int ans = -1;
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                ans = mid;
                i = mid+1;
            } else if(nums[mid] > target){
                j = mid-1;
            } else {
                i= mid+1;
            }
        }
        return ans;
    }
}