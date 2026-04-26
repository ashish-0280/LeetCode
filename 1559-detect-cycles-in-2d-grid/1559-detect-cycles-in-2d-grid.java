class Solution {
    public boolean containsCycle(char[][] grid) {

        int n = grid.length; int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j]){
                    if(bfs(grid, i, j, vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean bfs(char grid[][], int i, int j, boolean vis[][]){

        Queue<int[]> q = new LinkedList<>();
        int dx[] = {0, 1, -1, 0};
        int dy[] = {1, 0, 0, -1};
        q.add(new int[]{i, j, -1, -1});
        vis[i][j] = true;
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int x = arr[0], y = arr[1], px = arr[2], py = arr[3];
            for(int k=0; k<4; k++){
                int newX = x + dx[k];
                int newY = y + dy[k];
                
                if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[x][y] == grid[newX][newY]){

                    if(!vis[newX][newY]){
                        q.add(new int[]{newX, newY, x, y});
                        vis[newX][newY] = true;
                    } else {
                        if(newX != px || newY != py){
                            return true;
                        }
                    }
                    
                }
            }
        }
        return false;
    }
}