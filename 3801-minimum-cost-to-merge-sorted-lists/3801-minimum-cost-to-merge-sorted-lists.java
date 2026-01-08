class Solution {
    public long minMergeCost(int[][] lists) {
        int n = lists.length;
        int totalMasks = 1 << n;

        long[] dp = new long[totalMasks];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        int[] len = new int[totalMasks];
        int[] median = new int[totalMasks];

        for (int mask = 1; mask < totalMasks; mask++) {
            int totalLen = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    totalLen += lists[i].length;
                }
            }
            len[mask] = totalLen;
        }

        for (int mask = 1; mask < totalMasks; mask++) {
            median[mask] = findMedian(lists, mask);
        }

        for (int mask = 1; mask < totalMasks; mask++) {
            if ((mask & (mask - 1)) == 0) {
                dp[mask] = 0;
                continue;
            }

            for (int sub = (mask - 1) & mask; sub > 0; sub = (sub - 1) & mask) {
                int other = mask ^ sub;
                if (other == 0) continue;
                long cost = dp[sub] + dp[other]
                        + len[sub] + len[other]
                        + Math.abs((long) median[sub] - median[other]);
                dp[mask] = Math.min(dp[mask], cost);
            }
        }

        return dp[totalMasks - 1];
    }

    public int findMedian(int[][] lists, int mask) {
        List<int[]> included = new ArrayList<>();
        int totalLen = 0;
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < lists.length; i++) {
            if ((mask & (1 << i)) != 0) {
                included.add(lists[i]);
                totalLen += lists[i].length;
                minVal = Math.min(minVal, lists[i][0]);
                maxVal = Math.max(maxVal, lists[i][lists[i].length - 1]);
            }
        }

        int k = (totalLen - 1) / 2;

        int left = minVal, right = maxVal;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int[] arr : included) {
                count += upperBound(arr, mid);
            }
            if (count <= k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= target) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}