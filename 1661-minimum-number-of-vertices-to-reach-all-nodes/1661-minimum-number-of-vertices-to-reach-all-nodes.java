class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int inDegree[] = new int[n];
        for(int i=0; i<edges.size(); i++){
            int dest = edges.get(i).get(1);
            inDegree[dest]++;
        }
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                result.add(i);
            }
        }
        return result;
    }
}