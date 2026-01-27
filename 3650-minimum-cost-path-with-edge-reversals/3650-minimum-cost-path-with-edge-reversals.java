class Solution {
    class Pair{
        int x; long c;
        public Pair(int x, long c){
            this.x = x;
            this.c = c;
        }
    }
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> rev = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0]; int b = edges[i][1]; int c = edges[i][2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, 2*c});
        }
        int vis[] = new int[n];
        long d[] = new long[n];
        Arrays.fill(d, Long.MAX_VALUE);
        d[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.c, b.c));
        pq.add(new Pair(0, 0L));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int u = top.x;
            long c = top.c;
            if(c > d[u]) continue;
            if(u == n-1) return (int)d[u];
            for(int neighbour[]: graph.get(u)){
                int v = neighbour[0];
                int w = neighbour[1];
                if(d[u] + w < d[v]){
                    d[v] = d[u] + w;
                    pq.add(new Pair(v, d[v]));
                }
            }
            for(int neighbour[]: rev.get(u)){
                int v = neighbour[0];
                int w = neighbour[1];
                if(d[u] + w < d[v]){
                    d[v] = d[u] + w;
                    pq.add(new Pair(v, d[v]));
                }
            }
        }
        return -1;
    }
}