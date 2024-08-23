class Solution {
    public String removeOuterParentheses(String s) {
        String str = "";
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            } else {
                cnt--;
            }
            if(cnt > 1 && s.charAt(i) == '('){
                str += s.charAt(i);
            }
            else if(cnt > 0 && s.charAt(i) == ')'){
                str += s.charAt(i);
            }
        }
        return str;
    }
}