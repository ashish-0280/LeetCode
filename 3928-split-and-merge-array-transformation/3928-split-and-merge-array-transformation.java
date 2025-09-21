class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        List<Integer> start = new ArrayList<>();
        for (int x : nums1) start.add(x);
        List<Integer> target = new ArrayList<>();
        for (int x : nums2) target.add(x);

        if (start.equals(target)) return 0;

        Queue<List<Integer>> q = new LinkedList<>();
        Set<List<Integer>> seen = new HashSet<>();
        q.add(start);
        seen.add(start);

        int moves = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                List<Integer> cur = q.poll();
                if (cur.equals(target)) return moves;

                for (int l = 0; l < n; l++) {
                    for (int r = l; r < n; r++) {
                        List<Integer> cut = new ArrayList<>(cur.subList(l, r + 1));
                        List<Integer> remain = new ArrayList<>();
                        remain.addAll(cur.subList(0, l));
                        remain.addAll(cur.subList(r + 1, n));

                        for (int pos = 0; pos <= remain.size(); pos++) {
                            if (pos == l) continue;
                            List<Integer> next = new ArrayList<>(remain);
                            next.addAll(pos, cut);
                            if (seen.add(next)) q.add(next);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
