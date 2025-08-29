class Solution {
    public long flowerGame(int n, int m) {
        long cntEven1 = 0; long cntOdd1 = 0;
        long cntEven2 = 0; long cntOdd2 = 0;
        long ans = 0;
        if(n % 2 == 0){
            cntEven1 = n/2; cntOdd1 = n/2;
        } else {
            cntEven1 = n/2; cntOdd1 = n/2 + 1;
        }
        if(m % 2 == 0){
            cntEven2 = m/2; cntOdd2 = m/2;
        } else {
            cntEven2 = m/2; cntOdd2 = m/2 + 1;
        }
        ans = (long)ans + 1L * cntEven1 * cntOdd2 + 1L * cntEven2 * cntOdd1;
        return ans; 
    }
}