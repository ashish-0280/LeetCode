class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<m; j++){
                map.putIfAbsent(i-j, i-j < 0 ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder()));
                map.get(i-j).offer(grid[i][j]);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = map.get(i-j).poll();
            }
        }
        return grid;
    }
}