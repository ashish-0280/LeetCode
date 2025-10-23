class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int row[]: prerequisites){
            list.get(row[1]).add(row[0]);
        }
        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(list, i, vis, rec)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> list, int curr, boolean vis[], boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;

        for(int neighbour: list.get(curr)){
            if(!vis[neighbour]){
                if(dfs(list, neighbour, vis, rec)){
                    return true;
                }
            } else {
                if(rec[neighbour]){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }
}