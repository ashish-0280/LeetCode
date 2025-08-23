class Solution {
    int[][] grid;
    int n, m;

    public int minimumSum(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        int ans = Integer.MAX_VALUE / 3;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans,
                    Math.min(oneArea(0, 0, i, m - 1) + twoArea(i + 1, 0, n - 1, m - 1),
                            twoArea(0, 0, i, m - 1) + oneArea(i + 1, 0, n - 1, m - 1)));
        }

        for (int j = 0; j < m - 1; j++) {
            ans = Math.min(ans,
                    Math.min(oneArea(0, 0, n - 1, j) + twoArea(0, j + 1, n - 1, m - 1),
                            twoArea(0, 0, n - 1, j) + oneArea(0, j + 1, n - 1, m - 1)));
        }

        return ans;
    }

    public int twoArea(int r1, int c1, int r2, int c2) {
        int ans = Integer.MAX_VALUE / 2;
        for (int i = r1; i < r2; i++) {
            ans = Math.min(ans, oneArea(r1, c1, i, c2) + oneArea(i + 1, c1, r2, c2));
        }
        for (int j = c1; j < c2; j++) {
            ans = Math.min(ans, oneArea(r1, c1, r2, j) + oneArea(r1, j + 1, r2, c2));
        }
        return ans;
    }

    public int oneArea(int r1, int c1, int r2, int c2) {
        int left = c2, right = c1, up = r2, down = r1;
        boolean flag = false;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                }
            }
        }

        return !flag ? Integer.MAX_VALUE / 4 : (right - left + 1) * (down - up + 1);
    }
}
