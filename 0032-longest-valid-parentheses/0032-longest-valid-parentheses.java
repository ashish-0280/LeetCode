class Solution {
    public int longestValidParentheses(String s) {
        Stack <Integer> stk = new Stack<>();
        int maxLength = 0;
        stk.push(-1);
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stk.push(i);
            } else {
                stk.pop();
                if(stk.isEmpty()){
                    stk.push(i);
                } else {
                    maxLength = Math.max(maxLength, i-stk.peek());
                }
            }
        }
        return maxLength;
    }
}