class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] freq = new int[51];
        for (int i = 0; i < k; i++) freq[nums[i]]++;
        int[] ans = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            int[] copy = freq.clone();
            int sum = 0;
            for (int j = 0; j < x; j++) {
                int max = 0, idx = 0;
                for (int p = 50; p >= 0; p--) {
                    if (copy[p] > max) {
                        max = copy[p];
                        idx = p;
                    }
                }
                if (max == 0) break;
                sum += max * idx;
                copy[idx] = 0;
            }
            ans[i - (k - 1)] = sum;
            if (i + 1 == nums.length) continue;
            freq[nums[i - (k - 1)]]--;
            freq[nums[i + 1]]++;
        }
        return ans;
    }
}
