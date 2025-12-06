class Solution {
    int MOD = 1000000007;
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        int[] maxQ = new int[n];
        int[] minQ = new int[n];

        int maxFront = 0, maxBack = 0;  
        int minFront = 0, minBack = 0;  

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (maxBack > maxFront && nums[maxQ[maxBack - 1]] <= nums[right]) maxBack--;
            maxQ[maxBack++] = right;

            while (minBack > minFront && nums[minQ[minBack - 1]] >= nums[right]) minBack--;
            minQ[minBack++] = right;

            while (nums[maxQ[maxFront]] - nums[minQ[minFront]] > k) {
                if (maxQ[maxFront] == left) maxFront++;
                if (minQ[minFront] == left) minFront++;
                left++;
            }

            long ways = prefix[right];
            if (left > 0) ways = (ways - prefix[left - 1] + MOD) % MOD;

            dp[right + 1] = ways;
            prefix[right + 1] = (prefix[right] + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
