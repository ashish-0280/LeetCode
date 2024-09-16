class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        } else if(nums.length == 2){
            if(nums[0] > nums[1]){
                return 0;
            }
            return 1;
        } 
        return helper(nums, 0, 1, 2);
    }
    public int helper(int[] nums, int i, int j, int k){
        if(k>=nums.length){
            if(nums[j-1]<nums[k-1]){
                return nums.length - 1;
            } else {
                return 0;
            }
        }
        if(nums[i] < nums[j] && nums[j] > nums[k]){
            return j;
        }
        return helper(nums, i+1, j+1, k+1);
    }
}