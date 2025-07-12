class Solution {
    int min_r = Integer.MAX_VALUE;
    int max_r = Integer.MIN_VALUE;
    boolean[][][] visited = new boolean[27][27][27];

    public int[] earliestAndLatest(int n, int first, int second) {
        dfs((1 << n) - 1, 1, 0, 27, first - 1, second - 1,
            first - 1, second - first - 1, n - second);
        return new int[]{min_r, max_r};
    }

    void dfs(int mask, int round, int i, int j, int first, int second,
             int l, int m, int r) {
        
        if (i >= j) {
            dfs(mask, round + 1, 0, 27, first, second, l, m, r);
            return;
        }

        if ((mask & (1 << i)) == 0) {
            dfs(mask, round, i + 1, j, first, second, l, m, r);
            return;
        }

        if ((mask & (1 << j)) == 0) {
            dfs(mask, round, i, j - 1, first, second, l, m, r);
            return;
        }

        if (i == first && j == second) {
            min_r = Math.min(min_r, round);
            max_r = Math.max(max_r, round);
            return;
        }

        if (!visited[l][m][r]) {
            visited[l][m][r] = true;

            if (i != first && i != second) {
                int newL = l - ((i < first) ? 1 : 0);
                int newM = m - ((i > first && i < second) ? 1 : 0);
                int newR = r - ((i > second) ? 1 : 0);
                dfs(mask ^ (1 << i), round, i + 1, j - 1, first, second, newL, newM, newR);
            }

            if (j != first && j != second) {
                int newL = l - ((j < first) ? 1 : 0);
                int newM = m - ((j > first && j < second) ? 1 : 0);
                int newR = r - ((j > second) ? 1 : 0);
                dfs(mask ^ (1 << j), round, i + 1, j - 1, first, second, newL, newM, newR);
            }
        }
    }
}
