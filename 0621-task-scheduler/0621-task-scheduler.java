class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int freq[] = new int[26];
        for(int i=0; i<tasks.length; i++){
            freq[tasks[i]-'A']++;
        }
        for(int num: freq){
            if(num >= 1) pq.offer(num);
        }
        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;
            while(cycle > 0 && !pq.isEmpty()){
                int curr = pq.poll();
                if(curr > 1) temp.add(curr-1);
                time++; cycle--;
            }
            for(int remaining: temp){
                pq.offer(remaining);
            }
            if(pq.isEmpty()) break;
            time += cycle;
        }
        return time;
    }
}