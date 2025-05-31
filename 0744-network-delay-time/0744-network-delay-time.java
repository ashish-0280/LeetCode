class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        return dijkstra(n, times, k);
    }
    public int dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue <int[]> q = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int result[] = new int[V+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
        q.add(new int[]{0, src});
        
        while(!q.isEmpty()){
            int[] data = q.poll();
            int curr = data[1];
            int currWt = data[0];
            for(int[] neighbour: graph.get(curr)){
                int node = neighbour[0];
                int wt = neighbour[1];
                if(wt + currWt < result[node]){
                    result[node] = wt+currWt;
                    q.offer(new int[]{result[node], node});
                }
            }
        }
        int max = 0;
        for(int i=1; i<result.length; i++){
            if(result[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, result[i]);
        }
        return max;
    }
}