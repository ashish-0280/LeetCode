class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue <Long> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.add((long)nums[i]);
        }
        while(pq.size() >= 2 && !check(pq, k)){
            long data1 = pq.poll();
            long data2 = pq.poll();
            long data = 2*Math.min(data1, data2) + Math.max(data1, data2);
            pq.offer(data);
        }
        return nums.length - pq.size();
    }
    public boolean check(PriorityQueue <Long> pq, int k){
        List<Long> list = new ArrayList<>();
        while(!pq.isEmpty()){
            long data = pq.poll();
            list.add(data);
            if(data < (long)k){
                for(long num: list){
                    pq.add(num);
                }
                return false;
            }
        }
        for(long num: list){
            pq.add(num);
        }
        return true;
    }
}