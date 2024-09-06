class RecentCounter {
    Queue <Integer> q = new LinkedList<>();
    public RecentCounter() {
    
    }
    
    public int ping(int t) {
        if(!q.isEmpty()){
            int n = t-3000;
            int i=q.peek();
            while(i<n){
                q.poll();
                if(q.isEmpty()){
                    break;
                }
                i = q.peek();
            }
        }
        q.add(t);
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */