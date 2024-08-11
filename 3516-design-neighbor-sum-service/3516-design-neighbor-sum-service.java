class NeighborSum {
        Map <Integer, Integer> sum = new HashMap<>();
        Map <Integer, Integer> pdt = new HashMap<>();
    public NeighborSum(int[][] grid) {
        int row = 0;
        int col = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int sum1 = 0;
                row = i;
                col = j;
                if(row+1 < grid.length){
                    sum1 += grid[row+1][col];
                }
                if(col+1 < grid[0].length){
                    sum1 += grid[row][col+1];
                }
                if(row-1 >= 0){
                    sum1 += grid[row-1][col];
                }
                if(col-1 >= 0){
                    sum1 += grid[row][col-1];
                }
                int sum2 = 0;
                if(row+1 < grid.length && col+1 < grid[0].length){
                    sum2 += grid[row+1][col+1];
                }
                if(col+1 < grid[0].length && row-1 >= 0){
                    sum2 += grid[row-1][col+1];
                }
                if(row-1 >= 0 && col-1 >= 0){
                    sum2 += grid[row-1][col-1];
                }
                if(col-1 >= 0 && row+1 < grid.length){
                    sum2 += grid[row+1][col-1];
                }
                sum.put(grid[i][j], sum1);
                pdt.put(grid[i][j], sum2);
            }
        }
    }
    
    public int adjacentSum(int value) {
        return sum.get(value);
    }
    
    public int diagonalSum(int value) {
        return pdt.get(value);
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */