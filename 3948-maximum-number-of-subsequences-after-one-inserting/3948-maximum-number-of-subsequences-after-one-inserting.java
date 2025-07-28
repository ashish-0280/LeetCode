class Solution {
    public long numOfSubsequences(String s) {
        int n = s.length();
        int[] prefL = new int[n];
        int[] suffT = new int[n];

        // Build prefix sum for 'L'
        for (int i = 0; i < n; i++) {
            if (i > 0) prefL[i] = prefL[i - 1];
            if (s.charAt(i) == 'L') prefL[i]++;
        }

        // Build suffix sum for 'T'
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n) suffT[i] = suffT[i + 1];
            if (s.charAt(i) == 'T') suffT[i]++;
        }

        long ans = 0, best = 0, ansL = 0, ansT = 0;

        for (int i = 0; i < n; i++) {
            long p = (i - 1 >= 0) ? prefL[i - 1] : 0;
            long sf = (i + 1 < n) ? suffT[i + 1] : 0;

            if (s.charAt(i) == 'C') {
                ans += p * sf;
                ansL += (p + 1) * sf;
                ansT += p * (sf + 1);
            }

            // Consider inserting a 'C' here
            p = prefL[i];
            best = Math.max(best, p * sf);
        }

        return Math.max(Math.max(ans + best, ansL), ansT);
    }
}
