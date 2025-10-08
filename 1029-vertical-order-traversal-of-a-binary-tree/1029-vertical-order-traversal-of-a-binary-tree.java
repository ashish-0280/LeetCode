class Solution {
    class Pair {
        TreeNode node;
        int hd, level;
        public Pair(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd, level = p.level;

            map.putIfAbsent(hd, new TreeMap<>());
            map.get(hd).putIfAbsent(level, new PriorityQueue<>());
            map.get(hd).get(level).add(node.val);

            if (node.left != null) q.add(new Pair(node.left, hd - 1, level + 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1, level + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    col.add(nodes.poll());
                }
            }
            ans.add(col);
        }

        return ans;
    }
}
