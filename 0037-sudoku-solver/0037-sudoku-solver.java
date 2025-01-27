class Solution {
    public void solveSudoku(char[][] board) {
        sudoku(board, 0, 0);
    }
    public boolean sudoku(char board[][], int i, int j){
        if(i == board.length){
            return true;
        }
        if(j == board.length){
            return sudoku(board, i+1, 0);
        }
        if(board[i][j] != '.'){
            return sudoku(board, i, j+1);
        }
        for(char k='1'; k<='9'; k++){
            if(isValidSudoku(board, k, i, j)){
                board[i][j] = k;
                if(sudoku(board, i, j+1)){
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    public boolean isValidSudoku(char[][] board, char k, int i, int j) {
        for(int p=0; p<9; p++){
            if(board[i][p] == k || board[p][j] == k){
                return false;
            }
            int subRow = 3 * (i / 3) + p / 3;
            int subCol = 3 * (j / 3) + p % 3;
            if (board[subRow][subCol] == k) {
                return false;
            }
        }
        return true;
    }
}