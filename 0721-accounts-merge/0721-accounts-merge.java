class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        int n = accounts.size();
        int parent[] = new int[n];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        int rank[] = new int[n];
        Arrays.fill(rank, 0);
        HashMap<String, Integer> emailToId = new HashMap<>();
        for(int i=0; i<n; i++){
            List<String> account = accounts.get(i);
            String name = account.get(0);
            for(int j=1; j<account.size(); j++){
                String email = account.get(j);
                if(emailToId.containsKey(email)){
                    union(i, emailToId.get(email), parent, rank);
                }
                emailToId.put(email, i);
            }
        }
        HashMap<Integer, TreeSet<String>> merge = new HashMap<>();
        for(Map.Entry<String, Integer> entry: emailToId.entrySet()){
            String email = entry.getKey();
            int root = find(entry.getValue(), parent);
            merge.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }
        for (Map.Entry<Integer, TreeSet<String>> entry : merge.entrySet()) {
            List<String> mergedList = new ArrayList<>();
            mergedList.add(accounts.get(entry.getKey()).get(0));  // Add name
            mergedList.addAll(entry.getValue());  // Add sorted emails
            result.add(mergedList);
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