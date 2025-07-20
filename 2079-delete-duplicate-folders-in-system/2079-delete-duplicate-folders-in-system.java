class Solution {
    static class TrieNode {
        String name;
        Map<String, TrieNode> children = new HashMap<>();
        boolean isDeleted = false;

        TrieNode(String name) {
            this.name = name;
        }
    }

    Map<String, List<TrieNode>> map = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode("");

        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new TrieNode(folder));
                curr = curr.children.get(folder);
            }
        }

        solve(root);

        for (List<TrieNode> group : map.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.isDeleted = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    public String solve(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> list = new ArrayList<>();
        for (TrieNode child : node.children.values()) {
            String str = solve(child);  
            list.add("(" + child.name + str + ")");
        }

        Collections.sort(list);
        String structure = String.join("", list);

        if (!node.name.equals("")) {
            map.computeIfAbsent(structure, k -> new ArrayList<>()).add(node);
        }

        return structure;
    }

    private void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        if (node.isDeleted) return;

        if (!node.name.equals("")) {
            path.add(node.name);
            result.add(new ArrayList<>(path));
        }

        for (TrieNode child : node.children.values()) {
            collectPaths(child, path, result);
        }

        if (!path.isEmpty()) path.remove(path.size() - 1);
    }
}
