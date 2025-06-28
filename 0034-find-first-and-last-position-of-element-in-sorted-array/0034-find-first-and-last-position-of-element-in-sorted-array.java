class Solution {
    int ans[] = new int[2];
    public int[] searchRange(int[] nums, int target) {
        ans[0] = -1; ans[1] = -1;
        int i=0; int j=nums.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                ans[0] = findCeil(nums, target);
                ans[1] = findFloor(nums, target);
                return ans;
            } else if(nums[mid] > target){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return ans;
    }
    public int findFloor(int[] arr, int x) {
        // write code here
        int i=0; int j=arr.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid] <= x){
                i = mid+1;
            } else {
                j= mid-1;
            }
        }
        return j;
    }
    public int findCeil(int[] arr, int x) {
        // code here
        int i=0; int j=arr.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid] < x){
                i = mid+1;
            } else {
                j= mid-1;
            }
        }
        if(i==arr.length) return -1;
        
        return i;
    }
}