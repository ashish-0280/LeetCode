class Solution {
    long ans = 0;
    public long interactionCosts(int n, int[][] edges, int[] group) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int nodeCount[] = new int[21];
        for(int num: group){
            nodeCount[num]++;
        }
        for (int g = 1; g <= 20; g++) {
            dfs(0, -1, g, graph, group, nodeCount);
        }
        return ans;
    }
    public int dfs(int curr, int parent, int g, List<List<Integer>> graph, int[] group, int[] nodeCount) {

        int cnt = (group[curr] == g) ? 1 : 0;

        for (int neighbour : graph.get(curr)) {
            if (neighbour != parent) {
                cnt += dfs(neighbour, curr, g, graph, group, nodeCount);
            }
        }

        ans += 1L * cnt * (nodeCount[g] - cnt);
        return cnt;
    }
}