class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(s, new ArrayList<>(), result, 0);
        return result;
    }
    public void solve(String s, List<String> current, List<List<String>> result, int idx){
        if(idx == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                current.add(s.substring(idx, i+1));
                solve(s, current, result, i+1);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int idx1, int idx2){
        while(idx1 < idx2){
            if(s.charAt(idx1) != s.charAt(idx2)){
                return false;
            }
            idx1++; idx2--;
        }
        return true;
    }
}