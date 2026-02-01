class Solution {
    public long minimumCost(int[] nums, int k, int dist) {

        int n = nums.length;

        Comparator<Integer> cmp = (i, j) -> {
            if (nums[i] == nums[j]) return i - j;
            return nums[i] - nums[j];
        };

        TreeSet<Integer> selected = new TreeSet<>((a, b) -> {
            if(nums[a] == nums[b]) return a-b;
            return nums[a] - nums[b];
        });
        TreeSet<Integer> remaining = new TreeSet<>((a, b) -> {
            if(nums[a] == nums[b]) return a-b;
            return nums[a] - nums[b];
        });

        k = k - 1;

        long currentSum = 0;
        long answer = Long.MAX_VALUE;

        for (int i = 1; i <= Math.min(dist + 1, n - 1); i++) {
            currentSum += nums[i];
            selected.add(i);
        }

        while (selected.size() > k) {
            int idx = selected.pollLast();
            currentSum -= nums[idx];
            remaining.add(idx);
        }

        answer = currentSum;

        for (int right = dist + 2, left = 1; right < n; right++, left++) {

            remaining.add(right);

            if (selected.contains(left)) {
                selected.remove(left);
                currentSum -= nums[left];

                int smallest = remaining.pollFirst();
                selected.add(smallest);
                currentSum += nums[smallest];
            } else {
                remaining.remove(left);

                if (!selected.isEmpty() && !remaining.isEmpty()
                        && nums[selected.last()] > nums[remaining.first()]) {

                    int big = selected.pollLast();
                    currentSum -= nums[big];
                    remaining.add(big);

                    int small = remaining.pollFirst();
                    selected.add(small);
                    currentSum += nums[small];
                }
            }

            answer = Math.min(answer, currentSum);
        }

        return nums[0] + answer;
    }
}