class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap <Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i]%2;
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}