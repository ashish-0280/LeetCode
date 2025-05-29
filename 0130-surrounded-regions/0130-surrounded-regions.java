class Solution {
    public void solve(char[][] board) {
        int m = board.length; 
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O' && (i==0 || j==0 || i==m-1 || j==n-1)){
                    board[i][j] = '*';
                    q.offer(new int[]{i, j});
                }
            }
        }
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cell[] = q.poll();
                int row = cell[0]; int col = cell[1];
                for(int j=0; j<4; j++){
                    int x = row + dx[j];
                    int y = col + dy[j];
                    if(x>=0 && y>=0 && x<m && y<n && board[x][y] == 'O'){
                        board[x][y] = '*';
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        for(int x=0; x<m; x++){
            for(int y=0; y<n; y++){
                if(board[x][y] == 'O'){
                    board[x][y] = 'X';
                } else if(board[x][y] == '*'){
                    board[x][y] = 'O';
                }
            }
        }
    }
}