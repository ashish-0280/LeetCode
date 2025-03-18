class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i=0; int j = 0;
        int n = nums.length;
        int max = 1;
        int mask = 0;
        while(j<n){
            while(i<j && (nums[j] & mask) != 0){
                mask = mask ^ nums[i];
                i++;
            }
            mask = mask | nums[j];
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}