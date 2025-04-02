class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int parent[] = new int[26];
        int rank[] = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int i=0; i<n; i++){
            union(s1.charAt(i)-'a', s2.charAt(i)-'a', parent, rank);
        }
        TreeSet <Character> grade[] = new TreeSet[26];
        for(int i=0; i<26; i++){
            grade[i] = new TreeSet<>();
        }
        for(char ch='a'; ch<='z'; ch++){
            int root = find(ch-'a', parent);
            grade[root].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: baseStr.toCharArray()){
            int root = find(ch-'a', parent);
            sb.append(grade[root].first());
        }
        return sb.toString();
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