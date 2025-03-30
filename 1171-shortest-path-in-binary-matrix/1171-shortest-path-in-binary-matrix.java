class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        boolean vis[][] = new boolean[m][n];
        int directions[][] = {{1,0}, {0,1}, {1,1}, {-1,0}, {0,-1}, {-1,-1}, {1,-1}, {-1,1}};
        Queue <int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;
        int steps = 1;
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cell[] = q.poll();
                int x = cell[0]; int y = cell[1];
                if (x == m - 1 && y == n - 1) {
                    return steps;
                }
                for(int dir[]: directions){
                    int nx = x + dir[0]; int ny = y + dir[1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny] == 0 && !vis[nx][ny]){
                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}