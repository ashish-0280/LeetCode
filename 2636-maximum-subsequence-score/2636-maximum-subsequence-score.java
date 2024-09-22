class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
      
        int n = nums1.length;
        
        int[][] numsPairs = new int[n][2]; 
        for (int i = 0; i < n; ++i) {
            numsPairs[i] = new int[] {nums1[i], nums2[i]};
        }

        Arrays.sort(numsPairs, (a, b) -> b[1] - a[1]);
      
        long maxScore = 0;
        long sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            sum += numsPairs[i][0]; 
            minHeap.offer(numsPairs[i][0]); 
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * numsPairs[i][1]);
                sum -= minHeap.poll();
            }
        }
        return maxScore;
    }
}