class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long baseProfit = calculateProfit(prices, strategy);
        long prefixProfit[] = new long[n+1];
        long prefixPrice[] = new long[n+1];
        for(int i=0; i<n; i++){
            prefixProfit[i+1] = prefixProfit[i] + (long)prices[i] * strategy[i];
            prefixPrice[i+1] = prefixPrice[i] + prices[i];
        }
        long bestIncreament = 0;
        for(int i=0; i+k <= n; i++){
            long oldIncreament = prefixProfit[i+k] - prefixProfit[i];
            long newIncreament = prefixPrice[i+k] - prefixPrice[i+k/2];
            
            long increament = newIncreament - oldIncreament;
            bestIncreament = Math.max(bestIncreament, increament);
        }
        return bestIncreament <= 0 ? baseProfit : baseProfit + bestIncreament;
        
    }
    public long calculateProfit(int prices[], int nums[]){
        long profit = 0;
        for(int i=0; i<prices.length; i++){
            profit += prices[i] * nums[i];
        }
        return profit;
    }
}