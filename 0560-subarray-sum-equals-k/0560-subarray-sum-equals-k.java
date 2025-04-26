class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); int sum = 0;
        for (int i : nums) {
            sum += i;
            int sum2 = sum-k;
            count += map.getOrDefault(sum2, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}