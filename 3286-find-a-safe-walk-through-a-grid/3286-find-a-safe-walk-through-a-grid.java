class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int startHealth = health - grid.get(0).get(0);
        if(startHealth <= 0) return false;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, startHealth});
        int[][] best = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(best[i], -1);
        }
        best[0][0] = startHealth;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int h = curr[2];
            if(r == n - 1 && c == m - 1){
                return true;
            }

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                int nh = h - grid.get(nr).get(nc);
                if(nh <= 0)
                    continue;
                if(nh > best[nr][nc]){
                    best[nr][nc] = nh;
                    q.offer(new int[]{nr, nc, nh});
                }
            }
        }

        return false;
    }
}