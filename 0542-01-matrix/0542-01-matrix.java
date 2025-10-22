class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; 
        int n = mat[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        //int result[][] = new int[m][n];
        int steps = 1;
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
                    if(x>=0 && y>=0 && x<m && y<n && !vis[x][y]){
                        vis[x][y] = true;
                        mat[x][y] = steps;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        return mat;
    }
}