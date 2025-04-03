class Solution {
    public int minFlips(int a, int b, int c) {
        int d = a | b;
        int res = c ^ d;
        if(res == 0) return 0; int cnt = 0;
        for(int i=0; i<32; i++){
            int bit = (res >> i) & 1;
            if(bit == 1){
                if(((a>>i) & 1) == 1 && ((b>>i) & 1) == 1){
                    cnt += 2;
                } else {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}