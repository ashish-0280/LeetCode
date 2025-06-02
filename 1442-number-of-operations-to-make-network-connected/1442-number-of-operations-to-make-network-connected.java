class Solution {
    public int makeConnected(int n, int[][] connections) {
        int parent[] = new int[n];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        if(connections.length < n-1) return -1;
        int rank[] = new int[n];
        Arrays.fill(rank, 0);
        int cnt = 0;
        for(int conn[]: connections){
            int x = conn[0]; int y = conn[1];
            int x_parent = find(x, parent);
            int y_parent = find(y, parent);
            if(x_parent != y_parent) {
                cnt++;
                union(x, y, parent, rank);
            }
        }
        return n-1-cnt;
    }
    public int find(int i, int parent[]){
        if(i == parent[i]){
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
    public void union(int x, int y, int parent[], int rank[]){
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);
        if(x_parent == y_parent) return;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        } else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
}