class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] inDegree = new int[n];  // Count of incoming edges
        
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Construct the reverse graph and calculate in-degree
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);  // Reverse the edge
                inDegree[i]++;  // Increment in-degree
            }
        }

        // Queue for nodes with zero in-degree (terminal nodes)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process nodes with BFS
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : reverseGraph.get(node)) {
                inDegree[neighbor]--;  // Reduce in-degree
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        Collections.sort(safeNodes); // Ensure sorted order
        return safeNodes;
    }
}
