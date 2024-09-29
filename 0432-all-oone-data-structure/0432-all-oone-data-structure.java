class AllOne {
 private final Node root = new Node(); 
    private final Map<String, Node> nodes = new HashMap<>(); 

    public AllOne() {
        root.next = root;
        root.prev = root;
    }

    public void inc(String key) {
        if (!nodes.containsKey(key)) {
            if (root.next == root || root.next.cnt > 1) {
                nodes.put(key, root.insert(new Node(key, 1)));
            } else {
                root.next.keys.add(key);
                nodes.put(key, root.next);
            }
        } else {
            Node current = nodes.get(key);
            Node next = current.next;
            if (next == root || next.cnt > current.cnt + 1) {
                nodes.put(key, current.insert(new Node(key, current.cnt + 1)));
            } else {
                next.keys.add(key);
                nodes.put(key, next);
            }
            current.keys.remove(key);
            if (current.keys.isEmpty()) {
                current.remove();
            }
        }
    }

    public void dec(String key) {
        
        Node current = nodes.get(key);
        if (current.cnt == 1) {
           
            nodes.remove(key);
        } else {
            Node prev = current.prev;
            if (prev == root || prev.cnt < current.cnt - 1) {
                nodes.put(key, prev.insert(new Node(key, current.cnt - 1)));
            } else {
                prev.keys.add(key);
                nodes.put(key, prev);
            }
        }
      
        current.keys.remove(key);
        if (current.keys.isEmpty()) {
            current.remove();
        }
    }

    public String getMaxKey() {
        if (root.prev == root) return ""; 
        return root.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (root.next == root) return ""; 
        return root.next.keys.iterator().next();
    }
}

class Node {
    Node prev; 
    Node next; 
    int cnt; 
    Set<String> keys = new HashSet<>();
    public Node() {
        this("", 0);
    }

    public Node(String key, int cnt) {
        this.cnt = cnt;
        keys.add(key);
    }

    public Node insert(Node node) {
        node.prev = this;
        node.next = this.next;
        node.prev.next = node;
        node.next.prev = node;
        return node;
    }

    public void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */