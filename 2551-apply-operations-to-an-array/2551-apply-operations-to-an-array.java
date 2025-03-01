class Solution {
    public int[] applyOperations(int[] nums) {
        int arr[] = new int[nums.length];
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
            }
        }
        int j=0;
        for(int num: nums){
            if(num != 0){
                arr[j] = num;
                j++;
            }
        }
        return arr;
    }
}