class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int dist[][] = new int[n][k+1];
        for(int d[]: dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[0][1] = 0;
        pq.add(new int[]{0, 0, 1});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int d = curr[1];
            int count = curr[2];

            if(d > dist[node][count]) continue;

            if(node == n-1) return d;

            for(int e[]: graph.get(node)){
                int neighbour = e[0];
                int wt = e[1];

                int nextCount = (labels.charAt(node) == labels.charAt(neighbour)) ? count + 1 : 1;

                if(nextCount <= k){
                    if(wt + d < dist[neighbour][nextCount]){
                        dist[neighbour][nextCount] = wt + d;
                        pq.offer(new int[]{neighbour, wt + d, nextCount});
                    }
                }
            }
        }
        return -1;
    }
}