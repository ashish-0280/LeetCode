class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length; int m = matrix[0].length;
        boolean[][] mark = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    for (int p = 0; p < m; p++) mark[i][p] = true;
                    for (int q = 0; q < n; q++) mark[q][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mark[i][j]) matrix[i][j] = 0;
            }
        }
    }
}