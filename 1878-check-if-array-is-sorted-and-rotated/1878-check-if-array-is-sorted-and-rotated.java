class Solution {
    public boolean check(int[] nums) {
        int arr[] = new int[nums.length];
        int idx = 0;
        int n = nums.length;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                idx = i+1;
            }
        }
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[idx%n];
            idx++;
        }
        if(checks(arr)){
            return true;
        } else {
            return false;
        }
    }
    public boolean checks(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}