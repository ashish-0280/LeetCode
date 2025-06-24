class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int arr[]: prerequisites){
            graph.get(arr[0]).add(arr[1]);
            indegree[arr[1]]++;
        }
        if(isCycle(graph, numCourses)) return new int[0];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(int num: graph.get(curr)){
                indegree[num]--;
                if(indegree[num] == 0){
                    q.add(num);
                }
            }
        }
        Collections.reverse(ans);
        int arr[] = new int[ans.size()];
        int i=0;
        for(int num: ans){
            arr[i] = num;
            i++;
        }
        return arr;
    }
    public boolean isCycle(List<List<Integer>> graph, int n){
        boolean rec[] = new boolean[n];
        boolean vis[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(dfs(graph, n, vis, rec, i)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(List<List<Integer>> graph, int n, boolean vis[], boolean rec[], int curr){
        vis[curr] = true;
        rec[curr] = true;
        for(int neighbour: graph.get(curr)){
            if(!vis[neighbour]){
                if(dfs(graph, n, vis, rec, neighbour)){
                    return true;
                }
            } else {
                if(rec[neighbour]) return true;
            }
        }
        rec[curr] = false;
        return false;
    }
}