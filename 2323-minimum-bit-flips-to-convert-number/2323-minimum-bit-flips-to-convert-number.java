class Solution {
    public int minBitFlips(int start, int goal) {
        int cnt = 0;
        for(int i=0; i<30; i++){
            if(check(start, i) != check(goal, i)){
                cnt++;
            }
        }
        return cnt;
    }
    public int check(int n, int i){
        int bitmask = 1<<i;
        if((bitmask & n) == 0){
            return 0;
        } 
        return 1;
    }
}