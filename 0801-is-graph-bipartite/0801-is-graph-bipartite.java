class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);  // -1 = uncolored

        for (int start = 0; start < n; start++) {
            if (color[start] != -1) continue;  // already visited

            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            color[start] = 0; // start coloring

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];
                        q.offer(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        // same color on both ends of an edge → not bipartite
                        return false;
                    }
                }
            }
        }

        return true;  // no conflicts found
    }
}