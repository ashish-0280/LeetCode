import java.util.*;

class Solution {
    int[] parent;
    TreeSet<Integer>[] online;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;
        if (online[pa].size() < online[pb].size()) {
            parent[pa] = pb;
            online[pb].addAll(online[pa]);
        } else {
            parent[pb] = pa;
            online[pa].addAll(online[pb]);
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c];
        online = new TreeSet[c];

        for (int i = 0; i < c; i++) {
            parent[i] = i;
            online[i] = new TreeSet<>();
            online[i].add(i);
        }

        for (int[] con : connections) {
            int u = con[0] - 1, v = con[1] - 1;
            union(u, v);
        }

        List<Integer> res = new ArrayList<>();
        boolean[] isOnline = new boolean[c];
        Arrays.fill(isOnline, true);

        for (int[] q : queries) {
            int type = q[0], node = q[1] - 1;
            int root = find(node);

            if (type == 2) {
                if (isOnline[node]) {
                    online[root].remove(node);
                    isOnline[node] = false;
                }
            } else {
                if (isOnline[node]) {
                    res.add(node + 1);
                } else if (online[root].isEmpty()) {
                    res.add(-1);
                } else {
                    res.add(online[root].first() + 1);
                }
            }
        }
        int ans[] = new int[res.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
