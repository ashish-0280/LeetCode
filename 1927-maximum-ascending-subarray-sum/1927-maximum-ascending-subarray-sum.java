class Solution {
    public int maxAscendingSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int sum = nums[0];
        int i=0; int j=0;
        while(j<nums.length-1){
            if(nums[j+1] > nums[j]){
                sum += nums[j+1];
                max = Math.max(max, sum);
            } else {
                max = Math.max(max, sum);
                sum = nums[j+1];
                i = j+1;
            }
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}