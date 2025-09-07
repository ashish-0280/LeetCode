class Solution {
    public long bowlSubarrays(int[] nums) {
        long count = 0;
        Stack<Integer> stack = new Stack<>();

        for (int r = 0; r < nums.length; r++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[r]) {
                int l = stack.pop();
                if (r - l + 1 >= 3) {
                    count++;
                }
            }
            if (!stack.isEmpty() && r - stack.peek() + 1 >= 3) {
                count++;
            }
            stack.push(r);
        }

        return count;
    }
}