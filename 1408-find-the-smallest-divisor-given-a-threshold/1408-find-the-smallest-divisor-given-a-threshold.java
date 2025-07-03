class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int i=1; int j=findMax(nums); int ans = j;
        while(i<=j){
            int mid = (i+j)/2;
            if(solve(nums, threshold, mid)){
                ans = mid;
                j = mid-1;
            } else {
                i=mid+1;
            }
        }
        return ans;
    }
    public int findMax(int nums[]){
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
        }
        return max;
    }
    public boolean solve(int nums[], int threshold, int mid){
        int sum = 0;
        for(int num: nums){
            sum += Math.ceil((double)num/mid);
            if(sum > threshold){
                return false;
            }
        }
        return true;
    }
}