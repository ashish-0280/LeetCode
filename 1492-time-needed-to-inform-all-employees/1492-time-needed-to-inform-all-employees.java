class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<manager.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<manager.length; i++){
            if(manager[i] < 0) continue;
            graph.get(manager[i]).add(i);
        }
        return dfs(graph, headID, informTime);
    }
    public int dfs(List<List<Integer>> graph, int curr, int[] informTime){
        if(graph.get(curr).size() == 0){
            return 0;
        }
        int max = 0;
        for(int neighbour: graph.get(curr)){
            max = Math.max(max, dfs(graph, neighbour, informTime));
        }
        return max + informTime[curr];
    }
}