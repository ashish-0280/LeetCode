class Router {
    class Pair{
        int source; int destination; int timestamp;
        public Pair(int source, int destination, int timestamp){
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
        public boolean equals(Object obj) {
            return (obj instanceof Pair p) &&
                source == p.source &&
                destination == p.destination &&
                timestamp == p.timestamp;
        }

        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }
    Set<Pair> set;
    Map<Integer, List<Pair>> map;
    Deque<Pair> dq;
    int limit;
    public Router(int memoryLimit) {
        set = new HashSet<>();
        map = new HashMap<>();
        dq = new LinkedList<>();
        this.limit = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Pair p = new Pair(source, destination, timestamp);
        if(set.contains(p)) return false;
        if(set.size() == limit){
            Pair p1 = dq.pollFirst();
            set.remove(p1);
            map.get(p1.destination).removeAll(Collections.singleton(p1));
        }
        set.add(p);
        map.computeIfAbsent(destination, k -> new ArrayList<>());
        map.get(destination).add(p);
        dq.addLast(p);
        return true;
    }
    
    public int[] forwardPacket() {
        if(set.size() == 0) return new int[0];
        Pair p = dq.pollFirst();
        set.remove(p);
        map.get(p.destination).removeAll(Collections.singleton(p));
        return new int[]{p.source, p.destination, p.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Pair> l = map.get(destination);
        if(l == null) return 0;
        int leftIdx = floor(l, startTime);
        int rightIdx = ceil(l, endTime);
        if(leftIdx > rightIdx) return 0;
        return rightIdx - leftIdx + 1;
    }
    public int floor(List<Pair> l, int target){
        int i = 0, j = l.size() - 1, ans = l.size();
        while(i <= j){
            int mid = (i + j) / 2;
            if(l.get(mid).timestamp >= target){
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }
    public int ceil(List<Pair> l, int target){
        int i=0; int j=l.size()-1; int ans = -1;
        while(i <= j){
            int mid = (i+j)/2;
            if(l.get(mid).timestamp <= target){
                ans = mid;
                i=mid+1;
            } else {
                j=mid-1;
            }
        }
        return ans;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */