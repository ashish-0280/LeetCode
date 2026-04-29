class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;

        long[][] prefix = new long[n][n];
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                prefix[r][c] = grid[r][c];
            }
        }

        for (int c = 0; c < n; c++) {
            for (int r = 1; r < n; r++) {
                prefix[r][c] += prefix[r - 1][c];
            }
        }

        return dfs(0, prefix, -2, n, new Long[n][n + 2][4])[3];
    }

    public Long[] dfs(int col, long[][] prefix, int prev, int n, Long[][][] dp) {
        if (col == n) {
            return new Long[]{-1L, 0L, -1L, 0L};
        }

        if (dp[col][prev + 2][0] != null) {
            return dp[col][prev + 2];
        }

        long bestA = 0, rowA = -1;
        long bestB = 0, rowB = -1;

        for (int curr = -1; curr < n; curr++) {
            long gain = 0;

            if (col > 0 && prev != curr) {
                long prevSum = prev == -1 ? 0 : prefix[prev][col - 1];
                long currSum = curr == -1 ? 0 : prefix[curr][col];

                if (prev > curr) {
                    gain = prefix[prev][col] - currSum;
                } else {
                    gain = prefix[curr][col - 1] - prevSum;
                }
            }

            Long[] next = dfs(col + 1, prefix, curr, n, dp);
            long adjusted = gain;

            if (prev > curr && curr < next[2]) {
                adjusted -= prefix[(int) Math.min(prev, next[2])][col]
                        - (curr == -1 ? 0 : prefix[curr][col]);
            }

            if (curr <= prev) {
                if (next[1] + gain > bestA) {
                    bestA = next[1] + gain;
                    rowA = curr;
                }
                if (next[3] + adjusted > bestA) {
                    bestA = next[3] + adjusted;
                    rowA = curr;
                }
            } else {
                if (next[1] + gain > bestB) {
                    bestB = next[1] + gain;
                    rowB = curr;
                }
                if (next[3] + adjusted > bestB) {
                    bestB = next[3] + adjusted;
                    rowB = curr;
                }
            }
        }

        Long[] res = {rowA, bestA, rowB, bestB};
        dp[col][prev + 2] = res;
        return res;
    }
}