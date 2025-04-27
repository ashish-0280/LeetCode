class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int n = nums.length; int minIdx = -1; int maxIdx = -1;
        int culpritIdx = -1;
        for(int i=0; i<n; i++){
            if(nums[i]<minK || nums[i]>maxK){
                culpritIdx = i;
            }
            if(nums[i] == minK){
                minIdx = i;
            }
            if(nums[i] == maxK){
                maxIdx = i;
            }
            int temp = Math.min(minIdx, maxIdx) - culpritIdx;
            ans += temp <= 0 ? 0 : temp;
        }
        return ans;
    }
}