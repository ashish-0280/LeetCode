class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length; 
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                list.add(i);
            }
        }
        if(list.size() == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int p = 0; long ans = 0;
        for(int i=0; i<n; i++){
            pq.add(nums[i]);
            if(i == list.get(p)){
                ans += pq.poll();
                p++;
            }
            if(p == list.size()){
                break;
            }
        }
        return ans;
    }
}