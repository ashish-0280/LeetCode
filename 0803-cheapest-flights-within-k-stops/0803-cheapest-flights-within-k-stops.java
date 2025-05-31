class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans[] = dijkstra(n, flights, src, k);
        return ans[dst] == Integer.MAX_VALUE ? -1 : ans[dst];
    }
    public int[] dijkstra(int V, int[][] edges, int src, int k){
        // code here
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        Queue <int[]> q = new LinkedList<>();
        int result[] = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
        q.add(new int[]{0, src, 0});
        
        while(!q.isEmpty()){
            int[] data = q.poll();
            int curr = data[1];
            int currWt = data[0];
            int stops = data[2];
            if(stops > k){
                continue;
            }
            for(int[] neighbour: graph.get(curr)){
                int node = neighbour[0];
                int wt = neighbour[1];
                if(wt + currWt < result[node] && stops<=k){
                    result[node] = wt+currWt;
                    q.offer(new int[]{result[node], node, stops+1});
                }
            }
        }
        return result;
    }
}