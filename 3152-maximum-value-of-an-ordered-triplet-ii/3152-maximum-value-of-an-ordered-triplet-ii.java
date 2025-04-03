class Solution {
    public long maximumTripletValue(int[] nums) {
        int maxLeft[] = new int[nums.length];
        maxLeft[0] = nums[0];
        int maxRight[] = new int[nums.length];
        maxRight[nums.length-1] = nums[nums.length-1];
        for(int i=1; i<nums.length; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], nums[i]);
        }
        for(int i=nums.length-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], nums[i]);
        }
        long max = 0;
        for(int i=1; i<nums.length-1; i++){
            long ans = (long)(maxLeft[i-1] - nums[i]) * maxRight[i+1];
            max = Math.max(max, ans);
        }
        return max;
    }
}