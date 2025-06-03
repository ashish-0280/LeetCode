class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int n = nums.length;
        int i = 0, res = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int j = 0; j < n; j++) {
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            if (freq.get(nums[j]) == 1) {
                k--;
            }

            while (k < 0) {
                freq.put(nums[i], freq.get(nums[i]) - 1);
                if (freq.get(nums[i]) == 0) {
                    k++;
                }
                i++;
            }

            res += j - i + 1;
        }

        return res;
    }
}
