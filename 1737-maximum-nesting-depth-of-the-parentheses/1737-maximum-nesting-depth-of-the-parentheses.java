class Solution {
    public int maxDepth(String s) {
        Stack <Character> stk = new Stack<>();
        int cnt = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
                max = Math.max(max, cnt);
                stk.push('(');
            }
            if(s.charAt(i) == ')'){
                cnt--;
                stk.pop();
            }
        }
        return max;
    }
}