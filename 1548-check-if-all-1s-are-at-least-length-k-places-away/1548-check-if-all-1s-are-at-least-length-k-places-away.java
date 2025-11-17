class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int idx = -1;
        for(int i=0; i<nums.length; i++){
            if(idx != -1 && nums[i] == 1){
                if(i - idx < k+1){
                    return false;
                }
                idx = i;
            } else if(nums[i] == 1){
                idx = i;
            }
        }
        return true;
    }
}