class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int meetingCount[] = new int[n];
        long endTimes[] = new long[n];

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for(int meeting[]: meetings){
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            int free = -1;
            for(int i=0; i<n; i++){
                if(endTimes[i] <= start){
                    free = i;
                    break;
                }
            }
            if(free != -1){
                endTimes[free] = start + duration;
                meetingCount[free]++;
            } else {
                int earlyRoom = 0;
                long time = endTimes[0];
                for(int i=1; i<n; i++){
                    if(endTimes[i] < time){
                        time = endTimes[i];
                        earlyRoom = i;
                    }
                }
                endTimes[earlyRoom] = time + duration;
                meetingCount[earlyRoom]++;
            }
        }
        int max = 0; int room = 0;
        for(int i=0; i<n; i++){
            if(meetingCount[i] > max){
                max = meetingCount[i];
                room = i;
            }
        }
        return room;
    }
}