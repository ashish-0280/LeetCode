class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        sublist.add(0);
        solve(graph, 0, result, sublist);
        return result;
    }
    public void solve(int graph[][], int curr, List<List<Integer>> result, List<Integer> sublist){
        if(curr == graph.length-1){
            result.add(new ArrayList<>(sublist));
        }
        for(int v: graph[curr]){
            sublist.add(v);
            solve(graph, v, result, sublist);
            sublist.remove(sublist.size()-1);
        }
    }
}