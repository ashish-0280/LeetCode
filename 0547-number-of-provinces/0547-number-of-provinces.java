class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean visited[] = new boolean[isConnected.length+1];
        for(int i=0; i<isConnected.length; i++){
            if(visited[i] == false){
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }
    public void dfs(int isConnected[][], boolean visited[], int curr){
        visited[curr] = true;
        
        for(int i=0; i<isConnected[curr].length; i++){
            if(visited[i] == false && isConnected[curr][i] == 1){
                dfs(isConnected, visited, i);
            }
        }
    }
}