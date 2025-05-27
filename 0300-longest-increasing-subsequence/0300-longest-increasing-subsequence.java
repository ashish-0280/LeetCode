class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0; i<n; i++){
            for(int prev=0; prev<=i-1; prev++){
                if(nums[prev]<nums[i] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                }
            }
        }
        
        int sum = Integer.MIN_VALUE;
        for(int num: dp) sum = Math.max(sum, num);
        return sum;
    }
}