class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int row[]: trust){
            graph.get(row[0]-1).add(row[1]-1);
            indegree[row[1]-1]++;
        }
        for(int i=0; i<n; i++){
            if(indegree[i] == n-1 && graph.get(i).size() == 0){
                return i+1;
            }
        }
        return -1;
    }
}