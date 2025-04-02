class Solution {
    public long countPairs(int n, int[][] edges) {
        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int row[]: edges){
            union(row[0], row[1], parent, rank);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i, parent);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        if (map.size() == 1) return 0;

        long totalPairs = 0, sum = 0;
        for (int size : map.values()) sum += size;

        for (int size : map.values()) {
            sum -= size; 
            totalPairs += (long) size * sum; 
        }

        return totalPairs;
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
        if(x_parent == y_parent){
            return;
        }
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