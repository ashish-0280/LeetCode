class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean vis[] = new boolean[adj.size()];
        boolean rec[] = new boolean[adj.size()];
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                if(dfs(adj, vis, i, rec)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adj, boolean vis[], int curr, boolean rec[]){
        vis[curr] = true; rec[curr] = true;
        for(int i=0; i<adj.get(curr).size(); i++){
            int neighbour = adj.get(curr).get(i);
            if(!vis[neighbour]){
                if(dfs(adj, vis, neighbour, rec)){
                    return true;
                }
            } else if(rec[neighbour]){
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }
}