class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int parent[] = new int[n];
        int rank[] = new int[n];
        String st = strs[0];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j]) || strs[i].equals(strs[j])) {
                    union(i, j, parent, rank);
                }
            }
        }

       
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i, parent)); 
        }

        return set.size();
    }

    public boolean isSimilar(String a, String b) {
        int count = 0;
        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                diff.add(i);
            }
            if (count > 2) return false;
        }

        return count == 2 && a.charAt(diff.get(0)) == b.charAt(diff.get(1)) 
            && a.charAt(diff.get(1)) == b.charAt(diff.get(0));
    }

    // Find with Path Compression
    public int find(int i, int parent[]) {
        if (i != parent[i]) {
            parent[i] = find(parent[i], parent);
        }
        return parent[i];
    }

    // Union by Rank
    public void union(int x, int y, int parent[], int rank[]) {
        int x_root = find(x, parent);
        int y_root = find(y, parent);

        if (x_root == y_root) return;

        if (rank[x_root] > rank[y_root]) {
            parent[y_root] = x_root;
        } else if (rank[x_root] < rank[y_root]) {
            parent[x_root] = y_root;
        } else {
            parent[y_root] = x_root;
            rank[x_root]++;
        }
    }
}
