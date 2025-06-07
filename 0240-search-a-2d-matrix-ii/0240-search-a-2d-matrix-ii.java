class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row[]: matrix){
            if(search(row, target)) return true;
        }
        return false;
    }
    public boolean search(int nums[], int target){
        int i=0; int j=nums.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] > target){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return false;
    }
}