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
                bfs(adj, i, vis);
            }
        }
        return count;
    }
    public void bfs(List<List<Integer>> adj, int curr, boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(curr); vis[curr] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            for(int neighbour: adj.get(current)){
                if(!vis[neighbour]){
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
    }
}