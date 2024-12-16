class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0; i<k; i++){
            int minIdx = getMin(nums);
            nums[minIdx] *= multiplier;
        }
        return nums;
    }
    public int getMin(int nums[]){
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}