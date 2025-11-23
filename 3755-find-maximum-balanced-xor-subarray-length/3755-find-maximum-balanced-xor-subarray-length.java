class Solution {
    public int maxBalancedSubarray(int[] nums) {
        int xorSum = 0;
        int diff = 0;
        int maxLen = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);

        for (int i = 0; i < nums.length; i++) {
            xorSum ^= nums[i];
            diff += (nums[i] % 2 == 0) ? 1 : -1;

            String key = xorSum + "#" + diff;

            if (map.containsKey(key)) {
                maxLen = Math.max(maxLen, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return maxLen;
    }
}