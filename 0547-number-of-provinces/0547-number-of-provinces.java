class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        boolean vis[] = new boolean[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                cnt++;
                dfs(isConnected, i, vis);
            }
        }
        return cnt;
    }
    public void dfs(int[][] adj, int curr, boolean vis[]){
        vis[curr] = true;
        for(int i=0; i<adj[curr].length; i++){
            int neighbour = i;
            if(!vis[neighbour] && adj[curr][neighbour]==1){
                dfs(adj, neighbour, vis);
            }
        }
    }
}