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

        // Step 1: Trie banana
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new TrieNode(folder));
                curr = curr.children.get(folder);
            }
        }

        // Step 2: Serialize har node ka subtree
        serialize(root);

        // Step 3: Duplicate nodes ko delete mark karo
        for (List<TrieNode> group : map.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.isDeleted = true;
                }
            }
        }

        // Step 4: Final DFS to collect remaining folders
        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> serializedChildren = new ArrayList<>();
        for (TrieNode child : node.children.values()) {
            String serialized = serialize(child);  // Recursively call
            serializedChildren.add("(" + child.name + serialized + ")");
        }

        Collections.sort(serializedChildren);  // Important for unordered comparison
        String structure = String.join("", serializedChildren);

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

        if (!path.isEmpty()) path.remove(path.size() - 1); // Backtrack
    }
}
