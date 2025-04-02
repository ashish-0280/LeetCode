class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int row[]: trust){
            graph.get(row[0]).add(row[1]);
        }
        for(int i=1; i<graph.size(); i++){
            if(graph.get(i).size() == 0){
                int c = 0;
                for(int j=1; j<graph.size(); j++){
                    if(graph.get(j).contains(i)){
                        c++;
                    }
                }
                if(c == graph.size()-2){
                    return i;
                }
            }
        }
        return -1;
    }
}