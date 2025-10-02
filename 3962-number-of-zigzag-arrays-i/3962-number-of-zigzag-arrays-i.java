class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = 1000000007;
        int len = r - l + 1;

        int[] inc = new int[len];  
        int[] dec = new int[len]; 
        int[] nxtInc = new int[len];
        int[] nxtDec = new int[len];

        for (int i = 0; i < len; i++) {
            inc[i] = 1;
            dec[i] = 1;
            nxtInc[i] = 1;
            nxtDec[i] = 1;
        }

        for (int step = 0; step < n; step++) {
            for (int j = 0; j < len; j++) {
                nxtInc[j] = dec[j];
                nxtDec[j] = inc[j];
            }

            int prefInc = 0;
            int prefDec = 0;

            for (int j = 0; j < len; j++) {
                prefInc = (prefInc + nxtInc[j]) % mod;
                inc[j] = (prefInc - nxtInc[j] + mod) % mod;

                prefDec = (prefDec + nxtDec[len - 1 - j]) % mod;
                dec[len - 1 - j] = (prefDec - nxtDec[len - 1 - j] + mod) % mod;
            }
        }

        int ans = 0;
        for (int x : nxtInc) ans = (ans + x) % mod;
        for (int x : nxtDec) ans = (ans + x) % mod;

        return ans;
    }
}
