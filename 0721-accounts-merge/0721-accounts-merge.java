class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int parent[] = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        int rank[] = new int[n];
        Arrays.fill(rank, 0);
        Map<String, Integer> map1 = new HashMap<>();
        for(int i=0; i<n; i++){
            List<String> account = accounts.get(i);
            for(int j=1; j<account.size(); j++){
                String email = account.get(j);
                if(map1.containsKey(email)){
                    union(i, map1.get(email), parent, rank); 
                }
                map1.put(email, i);
            }
        }
        Map <Integer, TreeSet<String>> map2 = new HashMap<>();
        for(Map.Entry<String, Integer> entry: map1.entrySet()){
            int root = find(entry.getValue(), parent);
            if(map2.containsKey(root)){
                map2.get(root).add(entry.getKey());
                continue;
            }
            map2.put(root, new TreeSet<String>());
            map2.get(root).add(entry.getKey());
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, TreeSet<String>> entry: map2.entrySet()){
            List<String> l = new ArrayList<>();
            l.add(accounts.get(entry.getKey()).get(0));
            l.addAll(entry.getValue());
            result.add(l);
        }
        return result;
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