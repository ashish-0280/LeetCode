class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        int uniqueId = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int currArea = dfs(grid, i, j, uniqueId);
                    map.put(uniqueId, currArea);
                    maxArea = Math.max(maxArea, currArea);
                    uniqueId++;
                }
            }
        }
        int ans = maxArea;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();
                    for(int x=0; x<4; x++){
                        int p = i + dx[x];
                        int q = j + dy[x];
                        if(p<0 || q<0 || p>grid.length-1 || q>grid[0].length-1){
                            continue;
                        }
                        set.add(grid[p][q]);
                    }
                    int sum = 1;
                    for(int num: set){
                        if(map.containsKey(num)){
                            sum += map.get(num);
                        }
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
        return ans == 0 ? m*n : ans;
    }
    public int dfs(int grid[][], int x, int y, int id){
        if(x<0 || y<0 || x>grid.length-1 || y>grid[0].length-1 || grid[x][y] != 1) return 0;
        grid[x][y] = id;
        int size = 1;
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            size += dfs(grid, newX, newY, id);
        }
        return size;
    }
}