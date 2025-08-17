class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k == 0 || n >= k - 1 + maxPts){
            return 1.0;
        }
        double dp[] = new double[n + 1];
        dp[0] = 1.0; double window = 1.0; double result = 0.0; 
        for(int i=1; i<=n; i++){
            dp[i] = window / maxPts;
            if(i < k){
                window += dp[i];
            } else {
                result += dp[i];
            }
            int out = i - maxPts;
            if(out >= 0 && out < k){
                window = window - dp[out];
            }
        }
        return result;
    }
}