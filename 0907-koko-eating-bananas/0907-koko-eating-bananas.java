class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i=1; int max = 0;
        for(int num: piles){
            max = Math.max(max, num);
        }
        int j = max;
        int ans = max;
        while(i<=j){
            int mid = (i+j)/2;
            if(solve(piles, h, mid)){
                ans = mid;
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return ans;
    }
    public boolean solve(int piles[], int h, int mid){
        int sum = 0;
        for(int i=0; i<piles.length; i++){
            sum += Math.ceil((double)piles[i]/(double)mid);
            if(sum > h){
                return false;
            }
        }
        return true;
    }
}