class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0; int n = cardPoints.length;
        for(int i=0; i<n; i++){
            sum += cardPoints[i];
        }
        int sum2 = 0;
        int i=0; int j=n-k-1;
        for(int p=i; p<=j; p++){
            sum2 += cardPoints[p];
        }
        int max = Integer.MIN_VALUE;
        while(j<n && i<n){
            max = Math.max(max, sum-sum2);
            sum2 = sum2-cardPoints[i];
            i++;
            j++;
            if(j<n){
                sum2 = sum2 + cardPoints[j];
            } else {
                break;
            }
        }
        return max;
    }
}