class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int idx = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i; break;
            }
        }
        if(idx == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }
    
        for(int j=nums.length-1; j>idx; j--){
            if(nums[idx] < nums[j]){
                int temp = nums[idx];
                nums[idx] = nums[j];
                nums[j] = temp;
                break;
            }
        }
        reverse(nums, idx+1, nums.length-1);
    }
    public void reverse(int nums[], int idx1, int idx2){
        if(idx1 >= idx2){
            return;
        }
        while(idx1 < idx2){
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            idx1++; idx2--;
        }
    }
}