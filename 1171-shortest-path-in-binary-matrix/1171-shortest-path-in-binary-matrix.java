class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;
        if(m == 1 && n == 1) return 1;
        Queue <int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int dx[] = {0, 0, 1, -1, 1, -1, 1, -1};
        int dy[] = {1, -1, 1, -1, 0, 0, -1, 1};
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0; k<size; k++){
                int cell[] = q.poll();
                int row = cell[0]; int col = cell[1];
                for(int i=0; i<8; i++){
                    int x = row + dx[i];
                    int y = col + dy[i];
                    if(x == m-1 && y == n-1){
                        return steps+1;
                    }
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == 0){
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}