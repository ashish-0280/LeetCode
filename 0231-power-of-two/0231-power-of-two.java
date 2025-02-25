class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0 || n<0) return false;
        while(n>0){
            int last = n&1;
            if(last == 1){
                if(n != 1) return false;
            }
            n = n>>1;
        }
        return true;
    }
}