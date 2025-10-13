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
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll(); count++;
            ans.add(curr);
            for(int num: graph.get(curr)){
                indegree[num]--;
                if(indegree[num] == 0){
                    q.add(num);
                }
            }
        }
        if(count < numCourses) return new int[0];
        Collections.reverse(ans);
        int arr[] = new int[ans.size()];
        int i=0;
        for(int num: ans){
            arr[i] = num;
            i++;
        }
        return arr;
    }
}