class Solution {

    public class ModSegTree {
        public int n;
        public int[] mn, mx;

        public void init(int[] arr) {
            n = arr.length;
            mn = new int[4 * n];
            mx = new int[4 * n];
            build(1, 0, n - 1, arr);
        }

        public void build(int idx, int l, int r, int[] arr) {
            if (l == r) {
                mn[idx] = mx[idx] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(idx * 2, l, mid, arr);
            build(idx * 2 + 1, mid + 1, r, arr);
            mn[idx] = Math.min(mn[idx * 2], mn[idx * 2 + 1]);
            mx[idx] = Math.max(mx[idx * 2], mx[idx * 2 + 1]);
        }

        public int[] query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }

        public int[] query(int idx, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            if (ql <= l && r <= qr) return new int[]{mn[idx], mx[idx]};
            int mid = (l + r) / 2;
            int[] a = query(idx * 2, l, mid, ql, qr);
            int[] b = query(idx * 2 + 1, mid + 1, r, ql, qr);
            return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        }
    }

    public class MergeSortTree {
        public int n;
        public List<Long>[] vals;
        public List<Long>[] pref;

        public MergeSortTree(int n) {
            this.n = n;
            vals = new ArrayList[4 * n];
            pref = new ArrayList[4 * n];
            for (int i = 0; i < 4 * n; i++) {
                vals[i] = new ArrayList<>();
                pref[i] = new ArrayList<>();
            }
        }

        public void init(long[] arr) {
            build(1, 0, n - 1, arr);
        }

        public void build(int idx, int l, int r, long[] arr) {
            if (l == r) {
                vals[idx].add(arr[l]);
                pref[idx].add(arr[l]);
                return;
            }
            int mid = (l + r) / 2;
            build(idx * 2, l, mid, arr);
            build(idx * 2 + 1, mid + 1, r, arr);

            List<Long> L = vals[idx * 2];
            List<Long> R = vals[idx * 2 + 1];
            List<Long> V = vals[idx];
            V.clear();

            int i = 0, j = 0;
            while (i < L.size() || j < R.size()) {
                if (j == R.size() || (i < L.size() && L.get(i) <= R.get(j))) {
                    V.add(L.get(i++));
                } else {
                    V.add(R.get(j++));
                }
            }

            pref[idx].clear();
            long s = 0;
            for (long v : V) {
                s += v;
                pref[idx].add(s);
            }
        }

        public long[] queryLE(int l, int r, long x) {
            return queryLE(1, 0, n - 1, l, r, x);
        }

        public long[] queryLE(int idx, int l, int r, int ql, int qr, long x) {
            if (qr < l || r < ql) return new long[]{0, 0};
            if (ql <= l && r <= qr) {
                List<Long> V = vals[idx];
                List<Long> P = pref[idx];
                int pos = upperBound(V, x);
                long s = pos > 0 ? P.get(pos - 1) : 0;
                return new long[]{pos, s};
            }
            int mid = (l + r) / 2;
            long[] a = queryLE(idx * 2, l, mid, ql, qr, x);
            long[] b = queryLE(idx * 2 + 1, mid + 1, r, ql, qr, x);
            return new long[]{a[0] + b[0], a[1] + b[1]};
        }

        public long querySum(int l, int r) {
            return querySum(1, 0, n - 1, l, r);
        }

        public long querySum(int idx, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) return pref[idx].get(pref[idx].size() - 1);
            int mid = (l + r) / 2;
            return querySum(idx * 2, l, mid, ql, qr)
                    + querySum(idx * 2 + 1, mid + 1, r, ql, qr);
        }

        public int upperBound(List<Long> arr, long x) {
            int lo = 0, hi = arr.size();
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (arr.get(mid) <= x) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }

    public long binarySearchMedian(MergeSortTree mst, List<Long> uniq, int l, int r, long K) {
        int lo = 0, hi = uniq.size() - 1, best = hi;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            long v = uniq.get(mid);
            long cnt = mst.queryLE(l, r, v)[0];
            if (cnt >= K) {
                best = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return uniq.get(best);
    }

    public long[] minOperations(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int[] mods = new int[n];
        long[] scaled = new long[n];

        for (int i = 0; i < n; i++) {
            mods[i] = nums[i] % k;
            scaled[i] = nums[i] / (long) k;
        }

        ModSegTree modSeg = new ModSegTree();
        modSeg.init(mods);

        MergeSortTree mst = new MergeSortTree(n);
        mst.init(scaled);

        long[] tmp = scaled.clone();
        Arrays.sort(tmp);
        List<Long> uniq = new ArrayList<>();
        for (long v : tmp)
            if (uniq.isEmpty() || !uniq.get(uniq.size() - 1).equals(v))
                uniq.add(v);

        long[] ans = new long[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];

            int[] mm = modSeg.query(l, r);
            if (mm[0] != mm[1]) {
                ans[qi] = -1;
                continue;
            }

            int len = r - l + 1;
            long total = mst.querySum(l, r);

            int K = (len + 1) / 2;
            long med = binarySearchMedian(mst, uniq, l, r, K);

            long[] le = mst.queryLE(l, r, med);
            long cntLE = le[0], sumLE = le[1];
            long greater = len - cntLE;
            long sumGreater = total - sumLE;

            ans[qi] = med * cntLE - sumLE + sumGreater - med * greater;
        }

        return ans;
    }
}
