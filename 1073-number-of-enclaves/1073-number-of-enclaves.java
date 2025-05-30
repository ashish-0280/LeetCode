class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue <int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j] == 1){
                        grid[i][j] = 2;
                        q.offer(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        int dx[] = {1,-1,0,0};
        int dy[] = {0, 0, 1, -1};

        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cell[] = q.poll();
                for(int j=0; j<4; j++){
                    int x = cell[0] + dx[j];
                    int y = cell[1] + dy[j];
                    if(x>=0 && y>=0 && x<=m-1 && y<=n-1 && !vis[x][y]){
                        if(grid[x][y] == 1){
                            grid[x][y] = 2;
                            q.offer(new int[]{x,y});
                            vis[x][y] = true;
                        }
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}