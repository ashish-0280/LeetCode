class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solve(list, n*2, 0, new StringBuilder());
        return list;
    }
    public void solve(List<String> list, int n, int idx, StringBuilder s){
        if(s.length() == n){
            if(solve2(s.toString())){
                list.add(s.toString());
            }
            return;
        }
        if(idx >= n){
            return;
        }
        solve(list, n, idx+1, s.append('('));
        s.deleteCharAt(s.length()-1);
        solve(list, n, idx+1, s.append(')'));
        s.deleteCharAt(s.length()-1);
    }
    public boolean solve2(String s){
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!stk.isEmpty() && stk.peek() == '(' && s.charAt(i) == ')'){
                stk.pop();
            }
            else if(s.charAt(i) == '('){
                stk.push(s.charAt(i));
            } else {
                return false;
            }
        }
        return stk.isEmpty();
    }
}