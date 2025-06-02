class Solution {
    public int removeStones(int[][] stones) {
        int cnt = 0;
        int v = stones.length;
        Arrays.sort(stones, (a,b) -> Integer.compare(a[0], b[0]));
        int parent[] = new int[v];
        int rank[] = new int[v];
        for(int i=0; i<v; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int i=0; i<stones.length-1; i++){
            if(stones[i][0] == stones[i+1][0]){
                int parent_1 = find(i, parent);
                int parent_2 = find(i+1, parent);
                if(parent_1 != parent_2){
                    union(i, i+1, parent, rank);
                    cnt++;
                }
            }
            for(int j=i+1; j<stones.length; j++){
                if(stones[i][1] == stones[j][1]){
                    int parent_1 = find(i, parent);
                    int parent_2 = find(j, parent);
                    if(parent_1 != parent_2){
                        union(i, j, parent, rank);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
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