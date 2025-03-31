class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int directions[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        int number = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    number++;
                    dfs(grid, i, j, vis);
                }
                vis[i][j] = true;
            }
        }
        return number;
    }
    public void dfs(char grid[][], int i, int j, boolean vis[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        vis[i][j] = true;

        dfs(grid, i+1, j, vis);
        dfs(grid, i, j+1, vis);
        dfs(grid, i, j-1, vis);
        dfs(grid, i-1, j, vis);
    }
}