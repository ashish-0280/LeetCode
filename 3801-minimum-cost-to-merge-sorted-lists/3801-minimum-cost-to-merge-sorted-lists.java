class Solution {

    public long minMergeCost(int[][] lists) {
        int n = lists.length;
        int totalMasks = 1 << n;

        long[] dp = new long[totalMasks];
        Arrays.fill(dp, -1);

        int[] len = new int[totalMasks];
        int[] median = new int[totalMasks];

        for (int mask = 1; mask < totalMasks; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    sum += lists[i].length;
            }
            len[mask] = sum;
        }

        for (int mask = 1; mask < totalMasks; mask++) {
            median[mask] = findMedian(lists, mask);
        }

        return solve(totalMasks - 1, dp, len, median);
    }

    long solve(int mask, long[] dp, int[] len, int[] median) {
        if ((mask & (mask - 1)) == 0) return 0;
        if (dp[mask] != -1) return dp[mask];

        long ans = Long.MAX_VALUE;

        for (int sub = (mask - 1) & mask; sub > 0; sub = (sub - 1) & mask) {
            int other = mask ^ sub;
            if (other == 0) continue;

            long cost =
                    solve(sub, dp, len, median) +
                    solve(other, dp, len, median) +
                    len[sub] + len[other] +
                    Math.abs((long) median[sub] - median[other]);

            ans = Math.min(ans, cost);
        }

        return dp[mask] = ans;
    }

    int findMedian(int[][] lists, int mask) {
        List<int[]> included = new ArrayList<>();
        int total = 0;
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < lists.length; i++) {
            if ((mask & (1 << i)) != 0) {
                included.add(lists[i]);
                total += lists[i].length;
                minVal = Math.min(minVal, lists[i][0]);
                maxVal = Math.max(maxVal, lists[i][lists[i].length - 1]);
            }
        }

        int k = (total - 1) / 2;
        int l = minVal, r = maxVal;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int[] arr : included)
                cnt += upperBound(arr, mid);

            if (cnt <= k) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    int upperBound(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= x) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}
