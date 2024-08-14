class Solution {
    public int longestOnes(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int j = 0;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.containsKey(0) && map.get(0)>k){
                while(j<=i && map.get(0)>k){
                map.put(nums[j], map.get(nums[j])-1);
                    j++;
                }
            }
            max = Math.max(max, i-j+1);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}