class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int cnt = 0;
        int idx1 = 0; int idx2 = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }
        }
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                idx1 = i;
                break;
            }
        }
        for(int i=s2.length()-1; i>=0; i--){
            if(s1.charAt(i) != s2.charAt(i)){
                idx2 = i;
                break;
            }
        }
        if(cnt == 2){
            if(s1.charAt(idx1) == s2.charAt(idx2)) {
                if(s2.charAt(idx1) == s1.charAt(idx2)){
                    return true;
                }
            }
        }
        return false;
    }
}