class Solution {
    int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int u = edge[0]; int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        dfs(list, values, k, vis, 0);
        return ans;
    }
    public long dfs(List<List<Integer>> list, int values[], int k, boolean vis[], int curr){
        vis[curr] = true;
        long sum = values[curr];
        for(int neighbour: list.get(curr)){
            if(!vis[neighbour]){
                sum += dfs(list, values, k, vis, neighbour);
            }
        }
        if(sum % k == 0){
            ans++;
        }
        return sum;
    }
}