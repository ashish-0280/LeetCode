class Solution {
    public int trap(int[] height) {
        int arr[] = height;
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        leftMax[0] = arr[0]; rightMax[arr.length-1] = arr[arr.length-1];
        for(int i=1; i<arr.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        for(int i=arr.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }
        leftMax[0] = 0; rightMax[arr.length-1] = 0;
        int totalWater = 0;
        for(int i=0; i<arr.length; i++){
            int ht = Math.min(leftMax[i], rightMax[i]);
            if(ht <= arr[i]) continue;
            totalWater += ht - arr[i];
        }
        return totalWater;
    }
}