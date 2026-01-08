class Solution {
    public long minMergeCost(int[][] lists) {
        int n = lists.length;
        int limit = 1 << n;
        
        long[] dp = new long[limit];
        int[] medians = new int[limit];
        int[] lengths = new int[limit];
        
        Arrays.fill(dp, Long.MAX_VALUE);
        
        for (int mask = 1; mask < limit; mask++) {
            List<Integer> merged = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int val : lists[i]) {
                        merged.add(val);
                    }
                }
            }
            Collections.sort(merged);
            int size = merged.size();
            lengths[mask] = size;
            medians[mask] = merged.get((size - 1) / 2);
            
            if (Integer.bitCount(mask) == 1) {
                dp[mask] = 0;
            }
        }
        
        for (int mask = 1; mask < limit; mask++) {
            if (dp[mask] == Long.MAX_VALUE && Integer.bitCount(mask) > 1) {
                for (int submask = (mask - 1) & mask; submask > 0; submask = (submask - 1) & mask) {
                    int complement = mask ^ submask;
                    if (dp[submask] != Long.MAX_VALUE && dp[complement] != Long.MAX_VALUE) {
                        long currentCost = lengths[mask] + Math.abs((long) medians[submask] - medians[complement]);
                        dp[mask] = Math.min(dp[mask], dp[submask] + dp[complement] + currentCost);
                    }
                }
            }
        }
        
        return dp[limit - 1];
    }
}