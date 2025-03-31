class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int number = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0 && !vis[i][j]){
                    if(dfs(grid, i, j, vis)){
                        number++;
                    }
                }
            }
        }
        return number;
    }
    public boolean dfs(int grid[][], int i, int j, boolean vis[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return false;
        }
        if(grid[i][j] == 1 || vis[i][j]){
            return true;
        }
        vis[i][j] = true;

        boolean b1 = dfs(grid, i+1, j, vis);
        boolean b2 = dfs(grid, i, j+1, vis);
        boolean b3 = dfs(grid, i, j-1, vis);
        boolean b4 = dfs(grid, i-1, j, vis);
        return (b1 && b2 && b3 && b4);
    }
}