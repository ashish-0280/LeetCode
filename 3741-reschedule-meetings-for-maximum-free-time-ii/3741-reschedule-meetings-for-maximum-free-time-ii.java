class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if (n == 0) return eventTime;

        if (n == 1) {
            int duration = endTime[0] - startTime[0];
            return eventTime - duration;
        }
        // Build gap array
        int[] gap = new int[n + 1];
        gap[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gap[i] = startTime[i] - endTime[i - 1];
        }
        gap[n] = eventTime - endTime[n - 1];

        // Precompute suffix max array
        int[] suffixMax = new int[n + 2];
        suffixMax[n + 1] = 0;
        for (int i = n; i >= 0; i--) {
            suffixMax[i] = Math.max(gap[i], suffixMax[i + 1]);
        }

        int maxFree = 0;

        int prefixMax = 0;

        for (int i = 0; i < n; i++) {
            int duration = endTime[i] - startTime[i];

            // Remove meeting i → merge gaps i and i+1
            int mergedGap = gap[i] + gap[i + 1];

            boolean foundPlaceElsewhere = false;

            // Check left side
            if (prefixMax >= duration) {
                foundPlaceElsewhere = true;
            }

            // Check right side (beyond gap[i+1])
            if (suffixMax[i + 2] >= duration) {
                foundPlaceElsewhere = true;
            }

            if (foundPlaceElsewhere) {
                // Option 1: move meeting elsewhere
                maxFree = Math.max(maxFree, mergedGap + duration);
            } else {
                // Option 2: merge gaps but can't place meeting elsewhere
                maxFree = Math.max(maxFree, mergedGap);
            }

            prefixMax = Math.max(prefixMax, gap[i]);
        }
        return maxFree;

    }
}