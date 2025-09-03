class Solution {
    public long maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int maxBit = Integer.toBinaryString(max).length();
        int maxMask = (int)Math.pow(2, maxBit)-1;
        int dp[] = new int[maxMask+1];
        for(int num: nums){
            dp[num] = num;
        }
        for(int bit=0; bit<maxBit; bit++){
            for(int mask=0; mask <= maxMask; mask++){
                if((mask & (1<<bit)) != 0){
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1<<bit)]);
                }
            }
        }
        long ans = 0;
        for(int num: nums){
            ans = Math.max(ans, (long)num * dp[num ^ maxMask]);
        }
        return ans;
    }
}