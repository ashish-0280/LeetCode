class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a,b) -> Integer.compare(a[0], b[0]));
        long max = 0; long curr = 0; int i=0; int j=0;
        int n = coins.length;
        while(i < n){
            while(j < n && coins[j][1] - coins[i][0] + 1 <= k){
                curr += 1L * (coins[j][1] - coins[j][0] + 1) * coins[j][2];
                max = Math.max(max, curr);
                j++;
            }
            if(j < n){
                long remaining = 1L * Math.max(0, (k - (coins[j][0] - coins[i][0]))) * coins[j][2];
                max = Math.max(max, curr + remaining);
            }
            curr -= 1L * (coins[i][1] - coins[i][0] + 1) * coins[i][2];
            i++;
        }
        i = n-1; j = n-1; curr = 0;
        while(i >= 0){
            while(j >= 0 && coins[i][1] - coins[j][0] + 1 <= k){
                curr += 1L * (coins[j][1] - coins[j][0] + 1) * coins[j][2];
                max = Math.max(max, curr);
                j--;
            }
            if(j >= 0){
                long remaining = 1L * Math.max(0, (k - (coins[i][1] - coins[j][1]))) * coins[j][2];
                max = Math.max(max, curr + remaining);
            }
            curr -= 1L * (coins[i][1] - coins[i][0] + 1) * coins[i][2];
            i--;
        }
        return max;
    }
}