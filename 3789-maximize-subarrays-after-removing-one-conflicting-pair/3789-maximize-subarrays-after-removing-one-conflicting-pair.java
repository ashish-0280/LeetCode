class Solution {
    static class Pair {
        int R, k;
        Pair(int R, int k) {
            this.R = R;
            this.k = k;
        }
    }

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int m = conflictingPairs.length;

        // start[i] contains all (R, k) where i is the L of pair (L, R)
        List<List<Pair>> start = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            start.add(new ArrayList<>());
        }

        for (int k = 0; k < m; k++) {
            int a = conflictingPairs[k][0];
            int b = conflictingPairs[k][1];
            int L = Math.min(a, b);
            int R = Math.max(a, b);
            start.get(L).add(new Pair(R, k));
        }

        // TreeSet with custom comparator to sort by R, then k
        TreeSet<Pair> active = new TreeSet<>(
            (p1, p2) -> (p1.R != p2.R) ? Integer.compare(p1.R, p2.R) : Integer.compare(p1.k, p2.k)
        );

        int[] cnt = new int[n + 2];
        long base = 0;
        long[] improvement = new long[m];

        for (int i = n; i >= 1; i--) {
            for (Pair p : start.get(i)) {
                active.add(p);
                cnt[p.R]++;
            }

            if (active.isEmpty()) {
                base += (long)(n + 1 - i);
            } else {
                Pair first = active.first();
                int minR = first.R;
                base += (long)(minR - i);

                if (cnt[minR] == 1) {
                    int conflictIndex = first.k;

                    // Find the next smallest R value in active set after minR
                    Pair upperBound = new Pair(minR, Integer.MAX_VALUE);
                    Pair nextConflict = active.higher(upperBound);

                    int nextMinR = (nextConflict == null) ? (n + 1) : nextConflict.R;

                    improvement[conflictIndex] += (long)(nextMinR - minR);
                }
            }
        }

        long maxImprovement = 0;
        for (long val : improvement) {
            maxImprovement = Math.max(maxImprovement, val);
        }

        return base + maxImprovement;
    }
}