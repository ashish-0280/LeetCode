class Solution {
    public int numDupDigitsAtMostN(int n) {
        return n - countUniqueDigits(n);
    }

    private int countUniqueDigits(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int ans = 0;

        // Count numbers with length less than n
        for (int i = 1; i < len; i++) {
            ans += 9 * perm(9, i - 1);
        }

        // Count numbers with same length as n
        boolean[] used = new boolean[10];
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            for (int d = (i == 0 ? 1 : 0); d < digit; d++) {
                if (!used[d]) {
                    ans += perm(9 - i, len - i - 1);
                }
            }
            if (used[digit]) break;
            used[digit] = true;
            if (i == len - 1) ans++;  // n itself has unique digits
        }

        return ans;
    }

    private int perm(int m, int k) {
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= (m - i);
        }
        return res;
    }
}
