class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;
        
        long[] left = new long[len];
        long[] right = new long[len];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sumLeft = 0;
        for (int i = 0; i < 2 * n; i++) {
            sumLeft += nums[i];
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > n) {
                sumLeft -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                left[i] = sumLeft;
            } else {
                left[i] = Long.MAX_VALUE;
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumRight = 0;
        for (int i = len - 1; i >= n; i--) {
            sumRight += nums[i];
            minHeap.offer(nums[i]);
            if (minHeap.size() > n) {
                sumRight -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                right[i] = sumRight;
            } else {
                right[i] = Long.MIN_VALUE;
            }
        }

        // Compute minimum difference
        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (right[i + 1] != Long.MIN_VALUE) {
                res = Math.min(res, left[i] - right[i + 1]);
            }
        }
        return res;
    }
}