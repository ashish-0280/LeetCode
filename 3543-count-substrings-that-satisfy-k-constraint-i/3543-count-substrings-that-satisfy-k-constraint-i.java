class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            int zeroes = 0;
            int ones = 0;
            for(int j=i; j<s.length(); j++){
                if(s.charAt(j) == '0'){
                    zeroes++;
                } else if(s.charAt(j) == '1'){
                    ones++;
                }
                if(zeroes <= k || ones <= k){
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }
}