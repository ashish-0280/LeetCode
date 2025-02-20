class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solve(list, n, 0, 0, new StringBuilder());
        return list;
    }
    public void solve(List<String> list, int n, int idx1, int idx2, StringBuilder s){
        if(s.length() == n*2){
            list.add(s.toString());
            return;
        }
        if(idx1 < n){
            solve(list, n, idx1+1, idx2, s.append('('));
            s.deleteCharAt(s.length()-1);
        }
        if(idx2 < idx1){
            solve(list, n, idx1, idx2+1, s.append(')'));
            s.deleteCharAt(s.length()-1);
        }
    }
}