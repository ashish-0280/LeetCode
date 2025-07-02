class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = findmax(piles);
        int low = 1;
        int high = max;
        int ans = max;
        while(low<=high){
            int mid = (low+high)/2;
            if(calculateHours(piles, mid) <= h){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }
    public int findmax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public int calculateHours(int nums[], int k){
        int totalHours = 0;
        for(int i=0; i<nums.length; i++){
            totalHours += Math.ceil((double)nums[i]/(double)k);
        }
        return totalHours;
    }
}