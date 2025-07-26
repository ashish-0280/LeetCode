class Solution {
    static class P {
        int r, i;
        P(int r, int i) {
            this.r = r;
            this.i = i;
        }
    }

    public long maxSubarrays(int n, int[][] pairs) {
        int m = pairs.length;
        List<List<P>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = pairs[i][0];
            int b = pairs[i][1];
            int l = Math.min(a, b);
            int r = Math.max(a, b);
            list.get(l).add(new P(r, i));
        }

        TreeSet<P> set = new TreeSet<>((a, b) -> (a.r != b.r) ? Integer.compare(a.r, b.r) : Integer.compare(a.i, b.i));

        int[] freq = new int[n + 2];
        long base = 0;
        long[] gain = new long[m];

        for (int i = n; i >= 1; i--) {
            for (P p : list.get(i)) {
                set.add(p);
                freq[p.r]++;
            }

            if (set.isEmpty()) {
                base += n + 1 - i;
            } else {
                P p = set.first();
                int minR = p.r;
                base += minR - i;

                if (freq[minR] == 1) {
                    int idx = p.i;
                    P next = set.higher(new P(minR, Integer.MAX_VALUE));
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
