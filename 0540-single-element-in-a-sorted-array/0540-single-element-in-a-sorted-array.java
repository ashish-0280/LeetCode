class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int i=0; int j=nums.length-1; int n = nums.length;
        while(i<=j){
            int mid = (i+j)/2;
            if((mid == n-1 && nums[mid] != nums[mid-1]) || (mid==0 && nums[mid] != nums[mid+1]) || (nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid])){
                return nums[mid];
            } else if(mid>0 && nums[mid] == nums[mid-1]){
                if((mid-1)%2 == 0){
                    i=mid+1;
                } else {
                    j=mid-1;
                }
            } else if(mid < n-1 && nums[mid] == nums[mid+1]){
                if(((n-1)-mid-1)%2 == 0){
                    j=mid-1;
                } else {
                    i=mid+1;
                }
            }
        }
        return -1;
    }
}