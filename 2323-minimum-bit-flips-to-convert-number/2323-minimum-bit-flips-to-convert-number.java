class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        int cnt = 0;
        while(num > 0){
            cnt += num & 1;
            num >>= 1;
        }
        return cnt;
    }
}