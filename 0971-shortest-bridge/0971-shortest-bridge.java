class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue <int[]> q = new LinkedList<>();
        boolean found = false;

        int directions[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0; i<n; i++){
            if(found){
                break;
            }
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    found = true;
                    dfs(grid, i, j, q);
                    break;
                }
            }
        }
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cell[] = q.poll();
                int x = cell[0]; int y = cell[1];
                for(int dir[]: directions){
                    int nx = x + dir[0]; int ny = y + dir[1];
                    if(nx>=0 && nx<n && ny>=0 && ny<n){
                        if(grid[nx][ny] == 1){
                            return steps;
                        }
                        if(grid[nx][ny] == 0){
                            grid[nx][ny] = -1;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            steps++;
        }
        return steps;
    }
    public void dfs(int grid[][], int i, int j, Queue <int[]> q){
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || grid[i][j] != 1){
            return;
        }
        grid[i][j] = -1;
        q.offer(new int[]{i, j});

        dfs(grid, i+1, j, q);
        dfs(grid, i, j+1, q);
        dfs(grid, i, j-1, q);
        dfs(grid, i-1, j, q);
    }
}