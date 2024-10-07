class Solution {
    public int minLength(String s) {
        Stack <Character> stk = new Stack<>();
        int i = s.length()-1;
        while(i >= 0){
            if(!stk.isEmpty() && stk.peek() == 'D' && s.charAt(i) == 'C'){
                stk.pop();
                i--;
                continue;
            } else if(!stk.isEmpty() && stk.peek() == 'B' && s.charAt(i) == 'A'){
                stk.pop();
                i--;
                continue;
            }
            stk.push(s.charAt(i));
            i--;
        }
        return stk.size();
    }
}