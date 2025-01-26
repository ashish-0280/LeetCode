class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (char[] str : board) {
            Arrays.fill(str, '.');
        }
        nQueens(board, 0, n);
        return ans;
    }

    public void nQueens(char board[][], int row, int n) {
        if (row == board.length) {
            List<String> result = new ArrayList<>();
            for (char[] st : board) {
                result.add(new String(st));
            }
            ans.add(result);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i, n)) {
                board[row][i] = 'Q';
                nQueens(board, row + 1, n);
                board[row][i] = '.';
            }
        }
    }

    public boolean isSafe(char board[][], int i, int j, int n) {

        for (int p = i - 1; p >= 0; p--) {
            if (p < 0)
                break;
            if (board[p][j] =='Q') {
                return false;
            }
        }
        for (int p = j - 1; p >= 0; p--) {
            if (p < 0)
                break;
            if (board[i][p] == 'Q') {
                return false;
            }
        }
        // Bottom-Right
        for (int p = i - 1, q = j + 1; p >= 0 && q < n; p--, q++) {
            if (p < 0 || q > n - 1)
                break;
            if (board[p][q] == 'Q') {
                return false;
            }
        }
        // Bottom-Left
        for (int p = i - 1, q = j - 1; p >= 0 && q >= 0; p--, q--) {
            if (p < 0 || q < 0)
                break;
            if (board[p][q] == 'Q') {
                return false;
            }
        }
        return true;
    }
}