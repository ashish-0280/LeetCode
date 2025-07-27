class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            // Skip if nums[i] == nums[i - 1]
            if (nums[i] == nums[i - 1]) continue;

            // Find closest different left
            int left = i - 1;
            while (left >= 0 && nums[left] == nums[i]) left--;

            // Find closest different right
            int right = i + 1;
            while (right < n && nums[right] == nums[i]) right++;

            // Only check if both left and right are in bounds
            if (left >= 0 && right < n) {
                if (nums[i] > nums[left] && nums[i] > nums[right]) {
                    count++; // hill
                } else if (nums[i] < nums[left] && nums[i] < nums[right]) {
                    count++; // valley
                }
            }
        }

        return count;
    }
}