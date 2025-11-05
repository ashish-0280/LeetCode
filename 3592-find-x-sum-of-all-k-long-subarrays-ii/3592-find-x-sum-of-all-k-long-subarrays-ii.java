class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        TreeSet<long[]> top = new TreeSet<>((a, b) -> {
            if (a[1] == b[1]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        TreeSet<long[]> rest = new TreeSet<>((a, b) -> {
            if (a[1] == b[1]) return Long.compare(b[0], a[0]);
            return Long.compare(b[1], a[1]);
        });

        Map<Integer, long[]> freq = new HashMap<>();
        long[] ans = new long[nums.length - k + 1];
        long sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            long[] curr = freq.getOrDefault(nums[right], new long[2]);

            if (top.contains(curr)) {
                sum -= curr[0] * curr[1];
                top.remove(curr);
            } else {
                rest.remove(curr);
            }

            curr[0] = nums[right];
            curr[1]++;
            freq.put(nums[right], curr);
            rest.add(curr);

            if (left + k - 1 == right) {
                while (top.size() < x && !rest.isEmpty()) {
                    long[] next = rest.pollFirst();
                    sum += next[0] * next[1];
                    top.add(next);
                }

                ans[left] = sum;

                long[] rem = freq.get(nums[left]);
                if (top.contains(rem)) {
                    sum -= rem[0] * rem[1];
                    top.remove(rem);
                } else {
                    rest.remove(rem);
                }

                rem[1]--;
                if (rem[1] > 0) {
                    freq.put(nums[left], rem);
                    rest.add(rem);
                } else {
                    freq.remove(nums[left]);
                }

                if (!top.isEmpty()) {
                    long[] min = top.pollFirst();
                    sum -= min[0] * min[1];
                    rest.add(min);
                }

                left++;
            }
        }
        return ans;
    }
}
