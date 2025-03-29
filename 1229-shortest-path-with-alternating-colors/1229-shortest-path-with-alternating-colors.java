class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //Creating the required 2D Array of ArrayList
        List<Integer>[][] graph = new ArrayList[2][n];
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                graph[i][j] = new ArrayList<>();
            }   
        }
        for(int neighbour[]: redEdges){
            graph[0][neighbour[0]].add(neighbour[1]);
        }
        for(int neighbour[]: blueEdges){
            graph[1][neighbour[0]].add(neighbour[1]);
        }

        int result[] = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        
        //Applying BFS
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0}); //node, color, distance
        q.offer(new int[]{0, 1, 0});

        //Making Visited Array to not revist the same element with same color, that's why we make 2D Array Visited[node][color];
        boolean visited[][] = new boolean[n][2];
        visited[0][0] = true; //for 0th node red color true
        visited[0][1] = true; // for 0th node blue color true As we can start with any one of the color

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int node = curr[0], color = curr[1], distance = curr[2];
            
            for(int neighbour: graph[1-color][node]){
                if(!visited[neighbour][1-color]){
                    visited[neighbour][1-color] = true;
                    q.offer(new int[]{neighbour, 1-color, distance + 1});
                    if(result[neighbour] == -1){
                        result[neighbour] = distance + 1;
                    }
                }
            }
        }
        return result;
    }
}