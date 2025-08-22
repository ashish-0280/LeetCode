class Solution {
    public int minimumArea(int[][] grid) {
        int up = grid.length; int down = -1;
        int left = grid[0].length; int right = -1;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        int area = (Math.abs(up - down) + 1) * (Math.abs(left - right) + 1);
        return area;
    }
}