class Solution {
    public int colorTheGrid(int m, int n) {
        final int MOD = 1_000_000_007;
        int totalPatterns = 1;
        for (int i = 0; i < m; i++) totalPatterns *= 3;

        int[][] dp = new int[n + 1][totalPatterns];
        int[][] isCompatible = new int[totalPatterns][totalPatterns];
        List<Integer> validPatterns = new ArrayList<>();
        List<Integer>[] patternList = new ArrayList[totalPatterns];
        for (int i = 0; i < totalPatterns; i++) patternList[i] = new ArrayList<>();

        for (int pattern = 0; pattern < totalPatterns; pattern++) {
            int value = pattern;
            boolean isValid = true;
            for (int row = 0; row < m; row++) {
                patternList[pattern].add(value % 3);
                value /= 3;
            }
            for (int row = 1; row < m; row++) {
                if (patternList[pattern].get(row).equals(patternList[pattern].get(row - 1))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) validPatterns.add(pattern);
        }

        for (int pattern : validPatterns) {
            dp[1][pattern] = 1;
        }

        for (int pattern1 : validPatterns) {
            for (int pattern2 : validPatterns) {
                isCompatible[pattern1][pattern2] = 1;
                for (int row = 0; row < m; row++) {
                    if (patternList[pattern1].get(row).equals(patternList[pattern2].get(row))) {
                        isCompatible[pattern1][pattern2] = 0;
                        break;
                    }
                }
            }
        }

        for (int col = 2; col <= n; col++) {
            for (int currentPattern : validPatterns) {
                long totalWays = 0;
                for (int previousPattern : validPatterns) {
                    if (isCompatible[currentPattern][previousPattern] == 1) {
                        totalWays += dp[col - 1][previousPattern];
                    }
                }
                dp[col][currentPattern] = (int) (totalWays % MOD);
            }
        }

        long result = 0;
        for (int pattern = 0; pattern < totalPatterns; pattern++) {
            result += dp[n][pattern];
        }
        return (int) (result % MOD);
    }
}
