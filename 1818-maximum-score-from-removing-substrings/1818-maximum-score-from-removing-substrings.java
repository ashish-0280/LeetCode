class Solution {
    public int maximumGain(String str, int val1, int val2) {
        if (val1 > val2) {
            return solve(str, 'a', 'b', val1, val2);
        } else {
            return solve(str, 'b', 'a', val2, val1);
        }
    }

    public int solve(String str, char ch1, char ch2, int high, int low) {
        Stack<Character> stk = new Stack<>();
        int score = 0;

        for (char ch : str.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == ch1 && ch == ch2) {
                stk.pop();
                score += high;
            } else {
                stk.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        sb.reverse();

        stk.clear();
        for (char ch : sb.toString().toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == ch2 && ch == ch1) {
                stk.pop();
                score += low;
            } else {
                stk.push(ch);
            }
        }

        return score;
    }
}
