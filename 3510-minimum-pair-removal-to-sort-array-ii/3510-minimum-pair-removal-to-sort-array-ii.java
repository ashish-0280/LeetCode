class Solution {

    class Pair implements Comparable<Pair> {
        int l;
        long val, sum;
        Pair left, right;

        Pair(int l, long val) {
            this.l = l;
            this.val = val;
        }
        public int compareTo(Pair o) {
            if (this.right == null || o.right == null) {
                return this.right == null ? 1 : -1;
            }
            long d = this.sum - o.sum;
            return d != 0 ? (d < 0 ? -1 : 1) : (this.l - o.l);
        }
    }

    public int minimumPairRemoval(int[] nums) {

        TreeSet<Pair> heap = new TreeSet<>();
        int bad = 0;

        Pair cur = null;
        for (int i = 0; i < nums.length; i++) {
            Pair p = new Pair(i, nums[i]);
            if (cur == null) {
                cur = p;
            } else {
                if (p.val < cur.val) bad++;
                cur.right = p;
                p.left = cur;
                cur.sum = cur.val + p.val;
                heap.add(cur);
                cur = p;
            }
        }
        heap.add(cur);

        int ans = 0;

        while (bad > 0) {
            ans++;

            Pair best = heap.pollFirst();

            if (best.right.val < best.val) bad--;

            best.sum = best.val + best.right.sum;
            best.val = best.val + best.right.val;

            Pair del = best.right;
            best.right = del.right;

            if (del.right != null) {
                if (del.right.val < del.val) bad--;
                del.right.left = best;
                if (best.val > best.right.val) bad++;
            }

            heap.remove(del);
            heap.add(best);

            Pair left = best.left;
            if (left != null) {
                heap.remove(left);
                if (left.val > left.sum - left.val) bad--;
                if (left.val > best.val) bad++;
                left.sum = left.val + best.val;
                left.right = best;
                heap.add(left);
            }
        }
        return ans;
    }
}
