class Solution {
    Integer[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        // Step 1: Calculate total sum of array
        for (int num : nums) {
            sum += num;
        }

        // Step 2: Check if target is valid for conversion to subset sum
        if ((target + sum) % 2 != 0 || Math.abs(target) > sum) {
            return 0;  // Not possible to divide
        }

        // Step 3: Convert to subset sum problem
        int subsetSum = (target + sum) / 2;

        // Step 4: Initialize memoization table
        dp = new Integer[nums.length][subsetSum + 1];

        // Step 5: Count subsets with required sum
        return countSubsets(nums, 0, subsetSum);
    }

    // Recursive function with memoization
    private int countSubsets(int[] nums, int index, int sum) {
        // Base case: if we’ve gone through all elements
        if(sum < 0){
            return 0;
        }
        if (index == nums.length) {
            return sum == 0 ? 1 : 0;
        }

        // Check if answer is already computed
        if (dp[index][sum] != null) {
            return dp[index][sum];
        }

        // Option 1: Don't include current element
        int notTake = countSubsets(nums, index + 1, sum);

        // Option 2: Include current element (only if it's not more than sum)
        int take = countSubsets(nums, index + 1, sum - nums[index]);
        

        // Save result and return
        return dp[index][sum] = take + notTake;
    }
}
