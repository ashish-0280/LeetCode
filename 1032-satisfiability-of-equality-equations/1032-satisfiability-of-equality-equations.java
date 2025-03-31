class Solution {
    public boolean equationsPossible(String[] equations) {
        int parent[] = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
        }
        int rank[] = new int[26];
        Arrays.fill(rank, 0);
        for(String s: equations){
            if(s.charAt(1) == '='){
                union(s.charAt(0)-'a', s.charAt(3)-'a', parent, rank);
            }
        }
        for(String s: equations){
            if(s.charAt(1) == '!'){
                int parent_first = find(s.charAt(0)-'a', parent);
                int parent_second = find(s.charAt(3)-'a', parent);
                if(parent_first == parent_second){
                    return false;
                } 
            }
        }
        return true;
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