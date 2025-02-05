class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        System.out.println(adj);
        int indegree[] = new int[adj.size()];
        for(int i=0; i<adj.size(); i++){
            for(int neighbour: adj.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue <Integer> q = new LinkedList<>();
        for(int i=0; i<adj.size(); i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int data = q.poll();
            list.add(data);
            for(int j=0; j<adj.get(data).size(); j++){
                indegree[adj.get(data).get(j)]--;
                if(indegree[adj.get(data).get(j)] == 0){
                    q.add(adj.get(data).get(j));
                }
            }
        }
        int arr[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return list.size() == adj.size() ? arr : new int[0];
    }
}