class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long goodPairs = 0;
        long total = ((long)n*(n-1))/2;
        Map <Integer, Long> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]-i)){
                goodPairs += map.get(nums[i]-i);
            }
            map.put(nums[i]-i, map.getOrDefault(nums[i]-i, 0L)+1);
        }
        return total - goodPairs;
    }
}