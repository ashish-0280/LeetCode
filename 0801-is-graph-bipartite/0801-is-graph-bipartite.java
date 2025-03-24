class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!dfs(graph, color, i, 0)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph, int color[], int curr, int currColor){
        color[curr] = currColor;
        for(int v: graph[curr]){
            if(color[v] == color[curr]){
                return false;
            }
            if(color[v] == -1){
                if(!dfs(graph, color, v, 1-currColor)){
                    return false;
                }
            }
        }
        return true;
    }
}