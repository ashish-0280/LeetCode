class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            g.add(new ArrayList<>());
            for(int j=0; j<graph[i].length; j++){
                g.get(i).add(graph[i][j]);
            }
        }
        int color[] = new int[g.size()];
        Arrays.fill(color, -1);
        for(int i=0; i<g.size(); i++){
            if(color[i] == -1){
                if(!solve(g, color, i, 0)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solve(List<List<Integer>> graph, int color[], int curr, int currColor){
        color[curr] = currColor;
        for(int neighbour: graph.get(curr)){
            if(color[curr] == color[neighbour]){
                return false;
            }
            if(color[neighbour] == -1){
                if(!solve(graph, color, neighbour, 1 - currColor)){
                    return false;
                }
            }
        }
        return true;
    }
}