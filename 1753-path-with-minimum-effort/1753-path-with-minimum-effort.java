class Solution {
    class Cell{
        int x; int y; int distance;
        public Cell(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pq.add(new Cell(0, 0, 0));
        int result[][] = new int[m][n];
        for(int row[]: result) Arrays.fill(row, Integer.MAX_VALUE);
        result[0][0] = 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        while(!pq.isEmpty()){
            Cell cell = pq.poll();
            int x = cell.x; int y = cell.y; int distance = cell.distance;
            for(int i=0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX >= 0 && newY >= 0 && newX < m && newY < n){
                    int currDistance = Math.abs(heights[x][y] - heights[newX][newY]);
                    int maxDistance = Math.max(currDistance, distance);
                    if(maxDistance < result[newX][newY]){
                        result[newX][newY] = maxDistance;
                        pq.offer(new Cell(newX, newY, maxDistance));
                    }
                }
            }
        }
        return result[m-1][n-1] == Integer.MAX_VALUE ? -1 : result[m-1][n-1];
    }
}