class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map <Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, value -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, value -> new ArrayList<>()).add(u);
        }
        Queue <Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(source);
        vis[source] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == destination) return true;

            for(int neighbour: graph.get(curr)){
                if(!vis[neighbour]){
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return false;
    }
}