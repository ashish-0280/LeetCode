class Solution {
    List<List<Integer>> adj;
    int[] w, down, up, res;

    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        w = new int[n];
        for (int i = 0; i < n; i++) w[i] = good[i] == 1 ? 1 : -1;

        down = new int[n];
        up = new int[n];
        res = new int[n];

        dfs1(0, -1);
        dfs2(0, -1);

        return res;
    }

    void dfs1(int u, int p) {
        down[u] = w[u];
        for (int v : adj.get(u)) {
            if (v == p) continue;
            dfs1(v, u);
            down[u] += Math.max(0, down[v]);
        }
    }

    void dfs2(int u, int p) {
        res[u] = down[u] + up[u];
        for (int v : adj.get(u)) {
            if (v == p) continue;
            int rem = down[u] - Math.max(0, down[v]);
            up[v] = Math.max(0, up[u] + rem);
            dfs2(v, u);
        }
    }
}
