class Solution {
    int cnt = 0;
    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int u = edge[0]; int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        int weight[] = new int[n];
        for(int i=0; i<n; i++){
            if(good[i] == 0){
                weight[i] = -1;
            } else {
                weight[i] = 1;
            }
        }
        int ans[] = new int[n];
        int downScore[] = new int[n];
        int upScore[] = new int[n];

        dfs1(0, -1, list, weight, downScore);
        dfs2(0, -1, list, weight, upScore, downScore, ans);
        return ans;
    }
    public void dfs1(int curr, int parent, List<List<Integer>> list, int weight[], int downScore[]){
        downScore[curr] = weight[curr];
        for(int neighbour: list.get(curr)){
            if(neighbour == parent) continue;
            dfs1(neighbour, curr, list, weight, downScore);
            downScore[curr] += Math.max(0, downScore[neighbour]);
        }
    }
    public void dfs2(int curr, int parent, List<List<Integer>> list, int weight[], int upScore[], int downScore[], int ans[]){
        ans[curr] = downScore[curr] + upScore[curr];
        for(int neighbour : list.get(curr)){
            if(neighbour == parent) continue;
            int removeChildContrib = downScore[curr] - Math.max(0, downScore[neighbour]);
            upScore[neighbour] = Math.max(0, upScore[curr] + removeChildContrib);
            dfs2(neighbour, curr, list, weight, upScore, downScore, ans);
        }
    }
}