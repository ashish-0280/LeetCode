class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i=0; int cnt = 0; int n = events.length;
        int max = 0;
        for(int row[]: events){
            max = Math.max(row[1], max);
        }

        for(int day = 1; day <= max; day++){
            while(i<n && day == events[i][0]){
                pq.add(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                cnt++;
            }
        }
        return cnt;
    }
}