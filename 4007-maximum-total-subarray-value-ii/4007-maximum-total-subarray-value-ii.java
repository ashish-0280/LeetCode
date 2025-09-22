class Solution {

    public static final int INF_MIN = Integer.MIN_VALUE;
    public static final int INF_MAX = Integer.MAX_VALUE;

    public class Segment {
        public int[][] tree;
        public int n;

        public Segment(int[] arr) {
            n = arr.length;
            tree = new int[n * 4][2];
            build(arr, 0, 0, n - 1);
        }

        public int[] build(int[] arr, int idx, int l, int r) {
            if (l == r) {
                tree[idx][0] = arr[l];
                tree[idx][1] = arr[l];
                return tree[idx];
            }
            int mid = l + (r - l) / 2;
            int[] left = build(arr, idx * 2 + 1, l, mid);
            int[] right = build(arr, idx * 2 + 2, mid + 1, r);
            tree[idx][0] = Math.min(left[0], right[0]);
            tree[idx][1] = Math.max(left[1], right[1]);
            return tree[idx];
        }

        public int[] query(int idx, int ql, int qr, int l, int r) {
            if (ql > r || qr < l) return new int[]{INF_MAX, INF_MIN};
            if (ql <= l && qr >= r) return tree[idx];
            int mid = l + (r - l) / 2;
            int[] left = query(idx * 2 + 1, ql, qr, l, mid);
            int[] right = query(idx * 2 + 2, ql, qr, mid + 1, r);
            return new int[]{Math.min(left[0], right[0]), Math.max(left[1], right[1])};
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        Segment seg = new Segment(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        HashSet<Long> seen = new HashSet<>();
        int[] full = seg.query(0, 0, n - 1, 0, n - 1);
        pq.add(new int[]{full[1] - full[0], 0, n - 1});

        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int value = curr[0], l = curr[1], r = curr[2];
            result += value;
            if (l + 1 <= r && seen.add(((long) (l + 1) * n) + r)) {
                int[] left = seg.query(0, l + 1, r, 0, n - 1);
                pq.add(new int[]{left[1] - left[0], l + 1, r});
            }
            if (l <= r - 1 && seen.add(((long) l * n) + (r - 1))) {
                int[] right = seg.query(0, l, r - 1, 0, n - 1);
                pq.add(new int[]{right[1] - right[0], l, r - 1});
            }
            k--;
        }
        return result;
    }
}
