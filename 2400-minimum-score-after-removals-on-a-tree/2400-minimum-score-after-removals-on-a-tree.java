class Solution {
    static class Pair {
        int u, v;
        Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    List<Integer>[] graph;
    int[] nums, xor, in, out;
    int time = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        xor = new int[n];
        in = new int[n];
        out = new int[n];
        dfs(0, -1);

        int total = xor[0];
        int res = Integer.MAX_VALUE;

        List<Pair> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            if (isAncestor(a, b)) edgeList.add(new Pair(a, b));
            else edgeList.add(new Pair(b, a));
        }

        for (int i = 0; i < edgeList.size(); i++) {
            for (int j = i + 1; j < edgeList.size(); j++) {
                Pair e1 = edgeList.get(i), e2 = edgeList.get(j);
                int x, y, z;

                if (isAncestor(e1.v, e2.v)) {
                    x = xor[e2.v];
                    y = xor[e1.v] ^ x;
                    z = total ^ xor[e1.v];
                } else if (isAncestor(e2.v, e1.v)) {
                    x = xor[e1.v];
                    y = xor[e2.v] ^ x;
                    z = total ^ xor[e2.v];
                } else {
                    x = xor[e1.v];
                    y = xor[e2.v];
                    z = total ^ x ^ y;
                }

                int max = Math.max(x, Math.max(y, z));
                int min = Math.min(x, Math.min(y, z));
                res = Math.min(res, max - min);
            }
        }

        return res;
    }

    void dfs(int node, int parent) {
        in[node] = ++time;
        xor[node] = nums[node];
        for (int nei : graph[node]) {
            if (nei != parent) {
                dfs(nei, node);
                xor[node] ^= xor[nei];
            }
        }
        out[node] = ++time;
    }

    boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[u] >= out[v];
    }
}
