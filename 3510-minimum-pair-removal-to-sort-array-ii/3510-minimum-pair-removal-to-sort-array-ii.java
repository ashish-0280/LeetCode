class Solution {
    class Pair {
        long sum;
        int l, r;
        int time;

        Pair(long sum, int l, int r, int time) {
            this.sum = sum;
            this.l = l;
            this.r = r;
            this.time = time;
        }
    }
    public int minimumPairRemoval(int[] nums) {

        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, (long) nums[i]);
        }

        int bad = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) bad++;
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a, b) -> a.sum != b.sum ?
                Long.compare(a.sum, b.sum) :
                Integer.compare(a.l, b.l)
        );

        for (int i = 0; i < nums.length - 1; i++) {
            heap.add(new Pair(nums[i] + nums[i + 1], i, i + 1, 0));
        }

        int[] time = new int[nums.length];
        int ans = 0;

        while (bad > 0) {

            Pair p = heap.poll();

            if (!map.containsKey(p.l) || !map.containsKey(p.r))
                continue;

            if (time[p.l] > p.time || time[p.r] > p.time)
                continue;

            ans++;
            time[p.l] = ans;
            time[p.r] = ans;

            long leftVal = map.get(p.l);
            long rightVal = map.get(p.r);

            map.remove(p.r);

            if (rightVal < leftVal) bad--;

            map.put(p.l, p.sum);

            Map.Entry<Integer, Long> left = map.lowerEntry(p.l);
            if (left != null) {
                long v = left.getValue();
                if (p.sum < v) {
                    if (leftVal >= v) bad++;
                } else {
                    if (leftVal < v) bad--;
                }
                heap.add(new Pair(v + p.sum, left.getKey(), p.l, ans));
            }

            Map.Entry<Integer, Long> right = map.higherEntry(p.l);
            if (right != null) {
                long v = right.getValue();
                if (v < p.sum) {
                    if (rightVal <= v) bad++;
                } else {
                    if (rightVal > v) bad--;
                }
                heap.add(new Pair(v + p.sum, p.l, right.getKey(), ans));
            }
        }
        return ans;
    }
}
