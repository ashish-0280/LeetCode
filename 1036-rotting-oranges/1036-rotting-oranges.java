class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue <int[]> q = new LinkedList<>();
        int count_total = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] != 0){
                    count_total++;
                }
            }
        }
        int dx[] = {0, 0, 1, -1};
        int dy[] = {-1, 1, 0, 0};

        int time = 0; int cnt = 0;
        if(count_total == 0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            cnt += size;
            for(int i=0; i<size; i++){
                int[] p = q.poll();
                int r = p[0]; int c = p[1];
                for(int j=0; j<4; j++){
                    int x = r + dx[j];
                    int y = c + dy[j];
                    if(x<0 || y<0 || x>m-1 || y>n-1 || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }
                    grid[x][y] = 2;
                    q.add(new int[]{x, y});
                }
            }
            if(q.size() != 0) time++;
        }
        return cnt == count_total ? time : -1;
    }
}