class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length; int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % k != 0) return false;
        int target = sum/k;
        Arrays.sort(nums);
        Boolean[] dp = new Boolean[1 << n]; // memoization
        int[] subsetSum = new int[1 << n];  // current subset sum for each bitmask

        return canPartition((1 << n) - 1, 0, nums, dp, subsetSum, target);
    }

    private boolean canPartition(int mask, int currSum, int[] nums, Boolean[] dp, int[] subsetSum, int target) {
        if (mask == 0) return true; // all elements used

        if (dp[mask] != null) return dp[mask];

        int n = nums.length;
        dp[mask] = false;

        for (int i = 0; i < n; i++) {
            int bit = 1 << i;
            if ((mask & bit) != 0) { // if nums[i] is not used yet
                int newSum = (currSum + nums[i]);
                if (newSum > target) continue;

                int newMask = mask ^ bit; // mark nums[i] as used
                if (canPartition(newMask, newSum % target, nums, dp, subsetSum, target)) {
                    return dp[mask] = true;
                }
            }
        }

        return dp[mask];
    }
}