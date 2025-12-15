class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0; long cnt = 1;
        for(int i=1; i<prices.length; i++){
            if(prices[i] - prices[i-1] == -1){
                cnt++;
            } else {
                ans += (cnt * (cnt+1))/2;
                cnt = 1;
            }
        }
        ans += (cnt * (cnt + 1))/2;
        return ans;
    }
}