class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(memo.containsKey(s1+"$"+s2)){
            return memo.get(s1+"$"+s2);
        }
        if(s1.length() != s2.length()) return false;
        if(s1.equals("") && s2.equals("")) return true;
        if(s1.equals(s2)) return true;
        if(s1.length() <= 1) return false;
        int n = s1.length();
        boolean flag = false;
        for(int i=1; i<n; i++){
            if((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) || (isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i)))){
                flag = true;
                break;
            }
        }
        memo.put(s1+"$"+s2, flag);
        return flag;
    }
}