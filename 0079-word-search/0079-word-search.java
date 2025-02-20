class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(solve(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solve(char[][] board, String word, int row, int col, int idx) {
        if(idx == word.length()){
            return true;
        }
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0 || word.charAt(idx) != board[row][col]){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean ans = solve(board, word, row + 1, col, idx+1) || solve(board, word, row - 1, col, idx+1) || solve(board, word, row, col + 1, idx+1) || solve(board, word, row, col - 1, idx+1); 
        board[row][col] = temp;
        return ans;
    }
}