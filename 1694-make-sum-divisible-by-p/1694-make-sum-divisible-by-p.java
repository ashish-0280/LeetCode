class Solution {
    public int minSubarray(int[] nums, int p) {
        int remainder = 0;
        for (int num : nums) {
            remainder = (remainder + num) % p;
        }

        if (remainder == 0) {
            return 0;
        }

        Map<Integer, Integer> lastIndex = new HashMap<>();
        lastIndex.put(0, -1);

        int n = nums.length;
        int smallestLength = n;
        int currentSumModP = 0;

        for (int i = 0; i < n; ++i) {
            currentSumModP = (currentSumModP + nums[i]) % p;
            int target = (currentSumModP - remainder + p) % p;

            if (lastIndex.containsKey(target)) {
                smallestLength = Math.min(smallestLength, i - lastIndex.get(target));
            }

            lastIndex.put(currentSumModP, i);
        }

        return smallestLength == n ? -1 : smallestLength;
    }
}