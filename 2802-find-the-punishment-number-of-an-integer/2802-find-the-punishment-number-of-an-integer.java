class Solution {
    public int punishmentNumber(int n) {
        int cnt = 0;
        for(int i=1; i<n+1; i++){
            int sqr = i*i;
            if(check(Integer.toString(sqr), i, 0)){
                cnt += sqr;
            }
        }
        return cnt;
    }
    public boolean check(String sqr, int n, int idx){
        if(idx == sqr.length()) return n == 0;
        int num = 0;
        for(int i=idx; i<sqr.length(); i++){
            num = num*10 +(sqr.charAt(i)-'0');

            if(num > n){
                break;
            }
            if(check(sqr, n-num, i+1)){
                return true;
            }
        }
        return false;
    }
}