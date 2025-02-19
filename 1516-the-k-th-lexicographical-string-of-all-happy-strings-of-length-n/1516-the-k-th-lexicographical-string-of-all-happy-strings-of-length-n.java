class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        solve(list, n, new StringBuilder(), -1);
        System.out.println(list);
        return k>list.size() ? "" : list.get(k-1);
    }
    public void solve(List<String> list, int n, StringBuilder s, int idx){
        if(s.length() == n){
            list.add(s.toString());
            return;
        }
        if(idx >= n){
            return;
        }
        for(char i='a'; i<='c'; i++){
            if(s.length() == 0 || s.charAt(idx) != i){
                solve(list, n, s.append(i), idx+1);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
}