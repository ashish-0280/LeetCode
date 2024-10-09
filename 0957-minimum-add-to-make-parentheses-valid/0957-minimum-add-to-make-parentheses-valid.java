class Solution {
    public int minAddToMakeValid(String s) {
        Stack <Character> stk = new Stack<>();
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stk.push(s.charAt(i));
            } else {
                if(!stk.isEmpty()){
                    stk.pop();
                } else {
                    cnt++;
                }
            }
        }
        return cnt + stk.size();
    }
}