class Solution {
    public int countBinaryPalindromes(long n) {
        if(n == 0) return 1;
        int bits = (int)Long.toBinaryString(n).length();
        int total = 1;
        for(int i=1; i<bits; i++){
            int x = (i+1)/2 - 1;
            total += Math.pow(2, x);
        }
        int half = (bits + 1)/2;
        long prefix = (n >> (bits - half));
        String binaryPrefix = Long.toBinaryString(prefix);
        String str;
        if(bits % 2 == 0){
            str = binaryPrefix + new StringBuilder(binaryPrefix.substring(0, binaryPrefix.length())).reverse();
        } else {
            str = binaryPrefix + new StringBuilder(binaryPrefix.substring(0, binaryPrefix.length()-1)).reverse();
        }
        Long num = Long.parseLong(str, 2);
        total += prefix - (long)Math.pow(2, half - 1);
        if(num <= n) total++;
        return total;
    }
}