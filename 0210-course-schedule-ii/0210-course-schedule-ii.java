class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean vis1[] = new boolean[adj.size()];
        boolean rec[] = new boolean[adj.size()];
        for(int i=0; i<adj.size(); i++){
            if(!vis1[i]){
                if(cycle(adj, vis1, i, rec)){
                    return new int[0];
                }
            }
        }
        boolean vis[] = new boolean[adj.size()];
        Stack <Integer> s = new Stack<>();
        for(int i=0; i<adj.size(); i++){
            if(!vis[i]){
                dfs(adj, i, vis, s);
            }
        }
        int arr[] = new int[s.size()];
        int i=0;
        while(!s.isEmpty()){
            arr[i] = s.pop();
            i++;
        }
        return arr;
    }
    public static void dfs(List<List<Integer>> adj, int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;
        for(int i=0; i<adj.get(curr).size(); i++){
            int neighbour = adj.get(curr).get(i);
            if(!vis[neighbour]){
                vis[neighbour] = true;
                dfs(adj, neighbour, vis, s);
            } 
        }
        if(vis[curr]){
            s.push(curr);
        }
    }
    public boolean cycle(List<List<Integer>> adj, boolean vis[], int curr, boolean rec[]){
        vis[curr] = true; rec[curr] = true;
        for(int i=0; i<adj.get(curr).size(); i++){
            int neighbour = adj.get(curr).get(i);
            if(!vis[neighbour]){
                if(cycle(adj, vis, neighbour, rec)){
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