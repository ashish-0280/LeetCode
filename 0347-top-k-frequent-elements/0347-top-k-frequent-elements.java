class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            pq.offer(new int[]{val, key});
            if (pq.size() > k) {
                pq.poll(); 
            }
        }
        int ans[] = new int[k]; int i=0;
        while(k>0){
            ans[i] = pq.poll()[1];
            i++;
            k--;
        }
        return ans;
    }
}