class Solution {
    public int searchInsert(int[] nums, int target) {
        int lp = 0;
        int rp = nums.length-1;

        while(lp<=rp){
            int mid = (lp+rp)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                rp = mid-1;
            } else {
                lp = mid+1;
            }
        }
        return lp;
    }
}