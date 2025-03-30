class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; int n = mat[0].length;
        int result[][] = new int[m][n];
        Queue <int[]> q = new LinkedList<>();
        int directions[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int steps = 1;
        boolean vis[][] = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cell[] = q.poll();
                int x = cell[0]; int y = cell[1];
                for(int dir[]: directions){
                    int nx = x + dir[0]; int ny = y + dir[1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && !vis[nx][ny]){
                        vis[nx][ny] = true;
                        result[nx][ny] = steps;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            steps++;
        }
        return result;
    }
}