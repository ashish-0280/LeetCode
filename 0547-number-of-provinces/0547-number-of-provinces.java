class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                count++;
                dfs(adj, i, vis);
            }
        }
        return count;
    }
    public void dfs(List<List<Integer>> adj, int curr, boolean vis[]){
        vis[curr] = true;

        for(int neighbour: adj.get(curr)){
            if(!vis[neighbour]){
                vis[neighbour] = true;
                dfs(adj, neighbour, vis);
            }
        }
    }
}