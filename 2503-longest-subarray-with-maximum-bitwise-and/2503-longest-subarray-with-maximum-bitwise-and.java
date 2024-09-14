class Solution {
    public int longestSubarray(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        for(int num: nums){
            maxElement = Math.max(maxElement, num);
        }
        int currLen = 0;
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == maxElement){

                currLen++;
                maxLen = Math.max(currLen, maxLen);
            } else {
                currLen = 0;
            }
        }
        return maxLen;
    }
}