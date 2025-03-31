class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int total = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int num[] = new int[1];
                    dfs(grid, i, j, vis, num);
                    total = Math.max(total, num[0]);
                }
            }
        }
        return total;
    }
    public void dfs(int grid[][], int i, int j, boolean vis[][], int num[]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1){
            return;
        }
        num[0]++;
        vis[i][j] = true;
        grid[i][j] = -1;
        dfs(grid, i+1, j, vis, num);
        dfs(grid, i-1, j, vis, num);
        dfs(grid, i, j+1, vis, num);
        dfs(grid, i, j-1, vis, num);
    }
}