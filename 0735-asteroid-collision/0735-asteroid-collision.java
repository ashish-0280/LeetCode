class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            while (!stk.isEmpty() && asteroid < 0 && stk.peek() > 0) {
                if (stk.peek() < -asteroid) {
                    stk.pop();
                } else if (stk.peek() == -asteroid) {
                    stk.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                stk.push(asteroid);
            }
        }

        int[] ans = new int[stk.size()];
        for (int i = stk.size() - 1; i >= 0; i--) {
            ans[i] = stk.pop();
        }
        return ans;
    }
}
