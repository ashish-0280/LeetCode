class Solution {
    public long bowlSubarrays(int[] nums) {
        long count = 0;
        Stack<Integer> stk = new Stack<>();

        for (int right = 0; right < nums.length; right++) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[right]) {
                int left = stk.pop();
                if (right - left + 1 >= 3) {
                    count++;
                }
            }
            if (!stk.isEmpty() && right - stk.peek() + 1 >= 3) {
                count++;
            }
            stk.push(right);
        }

        return count;
    }
}