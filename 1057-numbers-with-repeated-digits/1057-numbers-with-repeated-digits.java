class Solution {
    public int numDupDigitsAtMostN(int n) {
        String s = String.valueOf(n);
        return n - countUniqueDigits(s, 0, 0, 1, 1, new boolean[10]);
    }

    public int countUniqueDigits(String s, int idx, int mask, int tight, int leadingZero, boolean[] used) {
        if (idx == s.length()) {
            return leadingZero == 1 ? 0 : 1;
        }

        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;
        int total = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            int newLeadingZero = (leadingZero == 1 && d == 0) ? 1 : 0;

            if (newLeadingZero == 1) {
                // Still leading zeros, don't mark digit as used
                total += countUniqueDigits(s, idx + 1, mask, newTight, newLeadingZero, used);
            } else {
                if (((mask >> d) & 1) == 1) continue; // digit already used
                total += countUniqueDigits(s, idx + 1, mask | (1 << d), newTight, 0, used);
            }
        }

        return total;
    }
}
