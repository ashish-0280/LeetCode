class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        int maxSize = Math.min(m, n);
        while(maxSize > 0){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(check(grid, i, j, maxSize)){
                        return maxSize;
                    }
                }
            }
            maxSize--;
        }
        return 1;
    }
    public boolean check(int grid[][], int i, int j, int size){
        if(i + size > grid.length || j+size > grid[0].length) return false;
        int target = 0;
        for(int k=i; k<i+size; k++){
            target += grid[k][j];
        }
        int col = j;
        while(col < j + size){
            int sum = 0;
            for(int row=i; row <i + size; row++){
                sum += grid[row][col];
            }
            if(sum != target) return false;
            col++;
        }
        int row = i;
        while(row < i + size){
            int sum = 0;
            for(col=j; col <j + size; col++){
                sum += grid[row][col];
            }
            if(sum != target) return false;
            row++;
        }
        row = i; col = j;
        int sum = 0;
        while(row < i + size && col < j + size){
            sum += grid[row][col];
            row++; col++;
        }
        if(sum != target) return false;
        row = i; col = j+size-1;
        sum = 0;
        while(row < i + size && col >= j){
            sum += grid[row][col];
            row++; col--;
        }
        if(sum != target) return false;
        return true;
    }
}