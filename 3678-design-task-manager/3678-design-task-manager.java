class TaskManager {
    class Pair {
        int userId, taskId, priority;
        public Pair(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    TreeSet<Pair> set;
    Map<Integer, Pair> map;

    public TaskManager(List<List<Integer>> tasks) {
        set = new TreeSet<>((a, b) -> {
            if (b.priority != a.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });
        map = new HashMap<>();
        for (List<Integer> l : tasks) {
            Pair p = new Pair(l.get(0), l.get(1), l.get(2));
            set.add(p);
            map.put(l.get(1), p);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Pair p = new Pair(userId, taskId, priority);
        set.add(p);
        map.put(taskId, p);
    }

    public void edit(int taskId, int newPriority) {
        Pair p = map.get(taskId);
        if (p == null) return;
        set.remove(p);
        Pair newPair = new Pair(p.userId, p.taskId, newPriority);
        set.add(newPair);
        map.put(taskId, newPair);
    }

    public void rmv(int taskId) {
        Pair p = map.remove(taskId);
        if (p != null) set.remove(p);
    }

    public int execTop() {
        if (set.isEmpty()) return -1;
        Pair p = set.pollFirst();
        map.remove(p.taskId);
        return p.userId;
    }
}
