class Solution {

    static class Pair {
        long sum;
        int l, r, ver;
        Pair(long s, int l, int r, int v) {
            sum = s; this.l = l; this.r = r; ver = v;
        }
    }

    public int minimumPairRemoval(int[] nums) {

        TreeMap<Integer, Long> arr = new TreeMap<>();
        for (int i = 0; i < nums.length; i++)
            arr.put(i, (long) nums[i]);

        int bad = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1]) bad++;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.sum != b.sum ?
                Long.compare(a.sum, b.sum) :
                Integer.compare(a.l, b.l)
        );

        for (int i = 0; i + 1 < nums.length; i++)
            pq.add(new Pair(nums[i] + nums[i + 1], i, i + 1, 0));

        int[] ver = new int[nums.length];
        int ans = 0;

        while (bad > 0) {

            Pair p = pq.poll();
            if (!arr.containsKey(p.l) || !arr.containsKey(p.r)) continue;
            if (ver[p.l] > p.ver || ver[p.r] > p.ver) continue;

            ans++;
            ver[p.l] = ver[p.r] = ans;

            long L = arr.get(p.l), R = arr.get(p.r);
            arr.remove(p.r);
            if (R < L) bad--;

            long merged = L + R;
            arr.put(p.l, merged);

            Integer left = arr.lowerKey(p.l);
            if (left != null) {
                long v = arr.get(left);
                if (merged < v && L >= v) bad++;
                if (merged >= v && L < v) bad--;
                pq.add(new Pair(v + merged, left, p.l, ans));
            }

            Integer right = arr.higherKey(p.l);
            if (right != null) {
                long v = arr.get(right);
                if (v < merged && R <= v) bad++;
                if (v >= merged && R > v) bad--;
                pq.add(new Pair(v + merged, p.l, right, ans));
            }
        }
        return ans;
    }
}
