class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<isConnected.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<isConnected[i].length; j++){
                if(i!=j){
                    if(isConnected[i][j] == 1){
                        list.add(j);
                    }
                }
            }
            adj.add(list);
        }
        System.out.println(adj);
        int cnt = 0;
        boolean vis[] = new boolean[adj.size()];
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                cnt++;
                dfs(adj, i, vis);
            }
        }
        return cnt;
    }
    public void dfs(List<List<Integer>> adj, int curr, boolean vis[]){
        vis[curr] = true;
        for(int i=0; i<adj.get(curr).size(); i++){
            int neighbour = adj.get(curr).get(i);
            if(!vis[neighbour]){
                dfs(adj, neighbour, vis);
            }
        }
    }
}