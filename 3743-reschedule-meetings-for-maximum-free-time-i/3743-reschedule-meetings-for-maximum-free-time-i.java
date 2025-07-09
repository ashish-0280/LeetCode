class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int gap[] = new int[n+1];
        gap[0] = startTime[0];
        for(int i=1; i<n; i++){
            gap[i] = startTime[i] - endTime[i-1];
        }
        gap[n] = eventTime - endTime[n-1];
        int window = k + 1;
        if(window > gap.length){
            int total = 0;
            for(int i=0; i<startTime.length; i++){
                total += endTime[i] - startTime[i];
            }
            return eventTime - total;
        }
        int currSum = 0; int maxSum = 0;
        for(int i=0; i<k+1; i++){
            currSum += gap[i];
        }
        if(maxSum < currSum){
            maxSum = currSum;
        }
        int i=0; int j=k+1;
        while(j<n+1){
            currSum = currSum - gap[i];
            currSum = currSum + gap[j];
            if(currSum > maxSum) maxSum = currSum;
            i++; j++;
        }
        return maxSum;
    }
}