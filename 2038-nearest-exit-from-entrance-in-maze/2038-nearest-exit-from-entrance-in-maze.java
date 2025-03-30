class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length; int n = maze[0].length;
        int directions[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue <int[]> q = new LinkedList<>();
        int a = entrance[0]; int b = entrance[1];
        q.add(new int[]{a, b});
        maze[a][b] = '+';
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cell[] = q.poll();
                int x = cell[0]; int y = cell[1];
                for(int dir[]: directions){
                    int nx = x + dir[0], ny = y + dir[1]; 
                    if(nx < m && ny < n && nx >= 0 && ny >=0 && maze[nx][ny] == '.'){
                        if((nx == 0 || ny == 0 || nx == m-1 || ny == n-1) && maze[nx][ny] == '.'){
                            return steps;
                        }
                        maze[nx][ny] = '+';
                        q.offer(new int[]{nx, ny});
                    } 
                }
            }
            steps++;
        }
        return -1;
    }
}