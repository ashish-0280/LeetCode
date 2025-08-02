class Solution {
    public long maximumProduct(int[] nums, int m) {
        long max = nums[0], min = nums[0], res = 1L * nums[0] * nums[m - 1];
        for (int i = m; i < nums.length; ++i) {
            max = Math.max(max, nums[i - m + 1]);
            min = Math.min(min, nums[i - m + 1]);
            res = Math.max(res, Math.max(min * nums[i], max * nums[i]));
        }
        return res;
    }
}
