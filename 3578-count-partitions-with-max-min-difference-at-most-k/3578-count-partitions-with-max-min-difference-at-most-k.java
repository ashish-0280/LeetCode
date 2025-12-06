class Solution {
    int MOD = 1000000007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;

        long totalPrefix = 1;  // prefix[right]
        long windowPrefix = 0; // prefix[left-1]

        ArrayDeque<Integer> maxQ = new ArrayDeque<>();
        ArrayDeque<Integer> minQ = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[right])
                maxQ.pollLast();
            maxQ.addLast(right);

            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[right])
                minQ.pollLast();
            minQ.addLast(right);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (maxQ.peekFirst() == left) maxQ.pollFirst();
                if (minQ.peekFirst() == left) minQ.pollFirst();

                // remove dp[left] from windowPrefix
                windowPrefix = (windowPrefix + dp[left]) % MOD;
                left++;
            }

            long ways = (totalPrefix - windowPrefix + MOD) % MOD;
            dp[right + 1] = ways;

            totalPrefix = (totalPrefix + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
