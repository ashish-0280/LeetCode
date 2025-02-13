class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue <Long> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.add((long)nums[i]);
        }
        while(pq.size() >= 2 && pq.peek()<(long)k){
            long data1 = pq.poll();
            long data2 = pq.poll();
            long data = 2*Math.min(data1, data2) + Math.max(data1, data2);
            pq.offer(data);
        }
        return nums.length - pq.size();
    }
}