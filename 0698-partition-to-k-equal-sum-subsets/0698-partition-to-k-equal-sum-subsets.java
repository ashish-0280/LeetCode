class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length; int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % k != 0) return false;
        int target = sum/k;
        Arrays.sort(nums);
        Boolean dp[] = new Boolean[1<<n];
        return solve(nums, 0, 0, target, dp);   
    }
    public boolean solve(int nums[], int mask, int currSum, int target, Boolean dp[]){
        if(mask == (1<<nums.length)-1) return true;
        if(dp[mask] != null) return dp[mask];
        dp[mask] = false;
        for(int i=0; i<nums.length; i++){
            if((mask & (1<<i)) == 0){
                int newSum = nums[i] + currSum;
                if(newSum > target) continue;
                int newMask = mask | (1<<i);
                if(solve(nums, newMask, newSum%target, target, dp)){
                    return dp[mask] = true;
                }
            }
        }
        return dp[mask];
    }
}