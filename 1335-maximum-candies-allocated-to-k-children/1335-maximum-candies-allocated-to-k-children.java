class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = findMax(candies);
        int low = 1; int high = max;
        while(low <= high){
            int mid = (low + high)/2;
            if(solve(mid, candies, k)){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }
    public boolean solve(int n, int arr[], long k){
        long cnt = 0;
        for(int i=0; i<arr.length; i++){
            int p = arr[i];
            cnt += p/n;
            if(cnt >= k){
                return true;
            }
        }
        return false;
    }
    public int findMax(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int num: arr){
            max = Math.max(num, max);
        }
        return max;
    }
}