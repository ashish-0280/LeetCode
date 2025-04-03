class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int inDegree[] = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++){
            int src = roads[i][0];
            int dest = roads[i][1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
            inDegree[src]++; inDegree[dest]++;
        }
        int max = 0;
        for(int i=0; i<graph.size()-1; i++){
            for(int j=i+1; j<graph.size(); j++){
                if(graph.get(i).contains(j) && graph.get(j).contains(i)){
                    max = Math.max(max, (inDegree[i] + inDegree[j] - 1));
                } else {
                    max = Math.max(max, inDegree[i] + inDegree[j]);
                }
            }
        }
        return max;
    }
}