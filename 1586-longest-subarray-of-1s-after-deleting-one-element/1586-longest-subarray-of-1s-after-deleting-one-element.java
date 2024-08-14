class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                count++;
            }
            if(count > 1){
                while(j<i && count>1){
                    if(nums[j] == 0){
                        count--;
                    }
                    j++;
                }
            }
            max = Math.max(max, i-j+1);
        }
        return max == Integer.MIN_VALUE ? 0 : max-1;
    }
}