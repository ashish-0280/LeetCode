class Solution {

    String s;
    int[] digits;
    int m;
    Map<String, Long> memo = new HashMap<>();

    public long countNoZeroPairs(long n) {
        s = Long.toString(n);
        m = s.length();
        digits = new int[m];
        for (int i = 0; i < m; i++) {
            digits[i] = s.charAt(m - 1 - i) - '0';
        }

        long total = 0;

        for (int la = 1; la <= m; la++) {
            for (int lb = 1; lb <= m; lb++) {
                memo.clear();
                total += dfs(0, 0, la, lb);
            }
        }

        return total;
    }

    long dfs(int pos, int carry, int la, int lb) {
        if (pos == m) {
            return carry == 0 ? 1 : 0;
        }

        String key = pos + "," + carry + "," + la + "," + lb;
        if (memo.containsKey(key)) return memo.get(key);

        long ways = 0;
        int target = digits[pos];

        int aStart = pos < la ? 1 : 0;
        int aEnd = pos < la ? 9 : 0;
        int bStart = pos < lb ? 1 : 0;
        int bEnd = pos < lb ? 9 : 0;

        for (int a = aStart; a <= aEnd; a++) {
            for (int b = bStart; b <= bEnd; b++) {
                int sum = a + b + carry;
                if (sum % 10 == target) {
                    ways += dfs(pos + 1, sum / 10, la, lb);
                }
            }
        }

        memo.put(key, ways);
        return ways;
    }
}
