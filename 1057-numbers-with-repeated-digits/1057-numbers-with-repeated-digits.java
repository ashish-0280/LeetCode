class Solution {
    public int numDupDigitsAtMostN(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int[][][][] dp = new int[len][1 << 10][2][2];
        for (int[][][] a : dp)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);

        return n - countUniqueDigits(s, 0, 0, 1, 1, dp);
    }

    public int countUniqueDigits(String s, int idx, int mask, int tight, int leadingZero, int[][][][] dp) {
        if (idx == s.length()) {
            return leadingZero == 1 ? 0 : 1; // exclude all-zero numbers
        }

        if (dp[idx][mask][tight][leadingZero] != -1) {
            return dp[idx][mask][tight][leadingZero];
        }

        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;
        int total = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            int newLeadingZero = (leadingZero == 1 && d == 0) ? 1 : 0;

            if (newLeadingZero == 1) {
                total += countUniqueDigits(s, idx + 1, mask, newTight, 1, dp);
            } else {
                if (((mask >> d) & 1) == 1) continue; // digit already used
                total += countUniqueDigits(s, idx + 1, mask | (1 << d), newTight, 0, dp);
            }
        }

        return dp[idx][mask][tight][leadingZero] = total;
    }
}
