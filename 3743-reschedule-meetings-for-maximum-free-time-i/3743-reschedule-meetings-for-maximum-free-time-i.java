class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if(k >= n){
            int totalDuration = 0;
            for(int i=0; i<n; i++){
                totalDuration += endTime[i] - startTime[i];
            }
            return eventTime - totalDuration;
        }
        int gap[] = new int[n+1];
        gap[0] = startTime[0];
        for(int i=1; i<n; i++){
            gap[i] = startTime[i] - endTime[i-1];
        }
        gap[n] = eventTime - endTime[n-1];
        int window = k+1;
        int currSum = 0; int maxSum = 0;
        for(int i=0; i<k+1; i++){
            currSum += gap[i];
        }
        maxSum = currSum;
        int i=0; int j=k+1;
        while(j<gap.length){
            currSum -= gap[i];
            currSum += gap[j];
            if(maxSum < currSum) maxSum = currSum;
            i++; j++;
        }
        return maxSum;
    }
}