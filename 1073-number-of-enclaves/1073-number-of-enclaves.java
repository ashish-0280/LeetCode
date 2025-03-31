class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int total = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int num[] = new int[1];
                    if(dfs(grid, i, j, vis, num)){
                        total += num[0];
                    }
                }
            }
        }
        return total;
    }
    public boolean dfs(int grid[][], int i, int j, boolean vis[][], int num[]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return false;
        }
        if(grid[i][j] == 0 || vis[i][j]){
            return true;
        }
        vis[i][j] = true;
        num[0]++;

        boolean b1 = dfs(grid, i+1, j, vis, num);
        boolean b2 = dfs(grid, i, j+1, vis, num);
        boolean b3 = dfs(grid, i, j-1, vis, num);
        boolean b4 = dfs(grid, i-1, j, vis, num);
        return (b1 && b2 && b3 && b4);
    }
}