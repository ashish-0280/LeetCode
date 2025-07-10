class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if(n == 0) return eventTime;
        if(n == 1) return eventTime - (endTime[0]-startTime[0]);

        int gap[] = new int[n+1];
        gap[0] = startTime[0];
        for(int i=1; i<n; i++){
            gap[i] = startTime[i] - endTime[i-1];
        }
        gap[n] = eventTime-endTime[n-1];

        int suffix[] = new int[n+2];
        suffix[n+1] = 0;
        for(int i=n; i>=0; i--){
            suffix[i] = Math.max(gap[i], suffix[i+1]);
        }
        int maxFreeTime = 0; int prefix = 0;
        for(int i=0; i<n; i++){
            int meetingTime = endTime[i] - startTime[i];
            boolean isFound = false;
            if(prefix >= meetingTime || suffix[i+2] >= meetingTime){
                isFound = true;
            }
            if(isFound){
                maxFreeTime = Math.max(maxFreeTime, gap[i] + gap[i+1] + meetingTime);
            } else {
                maxFreeTime = Math.max(maxFreeTime, gap[i] + gap[i+1]);
            }
            prefix = Math.max(prefix, gap[i]);
        }
        return maxFreeTime;
    }
}