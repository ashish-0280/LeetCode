class Solution {
    public boolean canReach(int[] arr, int start) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
            int val = arr[i];
            if(i+val < n){
                graph.get(i).add(i+val);
            }
            if(i-val >= 0){
                graph.get(i).add(i-val);
            }
        }
        System.out.println(graph);
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.offer(start);
        vis[start] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();
                if(arr[curr] == 0){
                    return true;
                }
                for(int neighbour: graph.get(curr)){
                    if(!vis[neighbour]){
                        vis[neighbour] = true;
                        q.offer(neighbour);
                    }
                }
            }
        }
        return false;
    }
}