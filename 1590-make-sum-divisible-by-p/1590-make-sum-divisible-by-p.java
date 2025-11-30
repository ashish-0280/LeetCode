class Solution {
    public int minSubarray(int[] nums, int p) {
        long rem = 0;
        for(int num: nums){
            rem += num;
        }
        rem = rem % p;
        if(rem == 0) return 0;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1); long curr = 0; int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            curr = (curr + nums[i]) % p;
            long target = (curr - rem + p) % p;
            if(map.containsKey(target)){
                min = Math.min(min, i-map.get(target));
            }
            map.put(curr, i);
        }
        if(min == nums.length || min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}