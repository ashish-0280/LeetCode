class Solution {
    class Cell{
        int x;
        int y;
        int distance;
        public Cell(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int dx[] = {0, 0, -1, 1};
        int dy[] = {1, -1, 0, 0};
        PriorityQueue<Cell> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        q.offer(new Cell(0, 0, 0));
        int result[][] = new int[m][n];
        for(int row[]: result){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Cell cell = q.poll();
            int x = cell.x; int y = cell.y; int distance = cell.distance;
            for(int i=0; i<4; i++){
                int newX = x + dx[i]; int newY = y + dy[i];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newDis = Math.abs(heights[newX][newY] - heights[x][y]);
                    int maxDis = Math.max(distance, newDis);
                    if(maxDis < result[newX][newY]){
                        result[newX][newY] = maxDis;
                        q.offer(new Cell(newX, newY, maxDis));
                    }
                }
            }
        }
        int ans = result[m-1][n-1];
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}