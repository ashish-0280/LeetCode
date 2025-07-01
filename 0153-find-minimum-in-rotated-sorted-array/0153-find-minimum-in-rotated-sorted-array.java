class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int i=0; int j=nums.length-1;
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            } else if(nums[mid] > nums[nums.length-1]){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return nums[0];
    }
}