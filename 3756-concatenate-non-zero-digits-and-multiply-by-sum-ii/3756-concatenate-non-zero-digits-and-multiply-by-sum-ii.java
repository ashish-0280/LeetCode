class Solution {
    int mod = 1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long prefixSum[] = new long[n];
        long preNonZeroNumber[] = new long[n];
        long preCount[] = new long[n];
        
        for(int i=0; i<n; i++){
            int digit = s.charAt(i) - '0';
            if(i > 0){
                prefixSum[i] = prefixSum[i-1];
                preNonZeroNumber[i] = preNonZeroNumber[i-1];
                preCount[i] = preCount[i-1];
            }
            if(digit != 0){
                prefixSum[i] += digit;
                preCount[i]++;
                preNonZeroNumber[i] = ((preNonZeroNumber[i] * 10) % mod + digit)%mod;
            }
        }
        long[] power = new long[n + 1];
        power[0] = 1;
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * 10) % mod;
        }
        int m = queries.length;
        int ans[] = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];

            long len = preCount[r] - ((l > 0) ? preCount[l - 1] : 0);
            long x = preNonZeroNumber[r];
            if (l > 0) {
                x = (x - (preNonZeroNumber[l - 1] * power[(int)len] % mod) + mod) % mod;
            }

            long sum = (prefixSum[r] - ((l > 0) ? prefixSum[l - 1] : 0)) % mod;
            ans[i] = (int) ((x * sum) % mod) % mod;
        }

        return ans;
    }
}