class Solution {
    static class Pair {
        int r, i;
        Pair(int r, int i) {
            this.r = r;
            this.i = i;
        }
    }

    public long maxSubarrays(int n, int[][] pairs) {
        int m = pairs.length;
        List<List<Pair>> starts = new ArrayList<>();
        for (int i = 0; i <= n; i++) starts.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = pairs[i][0], b = pairs[i][1];
            int l = Math.min(a, b), r = Math.max(a, b);
            starts.get(l).add(new Pair(r, i));
        }

        TreeSet<Pair> active = new TreeSet<>((a, b) ->
            (a.r != b.r) ? Integer.compare(a.r, b.r) : Integer.compare(a.i, b.i)
        );

        int[] freq = new int[n + 2];
        long base = 0;
        long[] gain = new long[m];

        for (int i = n; i >= 1; i--) {
            for (Pair p : starts.get(i)) {
                active.add(p);
                freq[p.r]++;
            }

            if (active.isEmpty()) {
                base += n + 1 - i;
            } else {
                Pair p = active.first();
                int minR = p.r;
                base += minR - i;

                if (freq[minR] == 1) {
                    int idx = p.i;
                    Pair next = active.higher(new Pair(minR, Integer.MAX_VALUE));
                    int nextR = (next == null) ? (n + 1) : next.r;
                    gain[idx] += nextR - minR;
                }
            }
        }

        long max = 0;
        for (long g : gain) max = Math.max(max, g);

        return base + max;
    }
}
