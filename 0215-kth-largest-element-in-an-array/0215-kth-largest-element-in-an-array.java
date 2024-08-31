class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        int j=1;
        while(j<k){
            pq.remove();
            j++;
        }
        return pq.remove();
    }
}