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
        int cnt = 0;
        boolean vis[] = new boolean[adj.size()];
        Queue <Integer> q = new LinkedList<>();
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                cnt++;
                q.offer(i);
                bfs(adj, q, vis);
            }
        }
        return cnt;
    }
    public void bfs(List<List<Integer>> adj, Queue <Integer> q, boolean vis[]){
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i=0; i<adj.get(curr).size(); i++){
                if(!vis[adj.get(curr).get(i)]){
                    q.offer(adj.get(curr).get(i));
                    vis[adj.get(curr).get(i)] = true;
                }
            }
        }
    }
}