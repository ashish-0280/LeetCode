class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int a[] = new int[height.length];
        int b[] = new int[height.length];
        solve(height, a, b);
        for(int i=0; i<height.length; i++){
            int ht = Math.min(a[i], b[i])-height[i];
            totalWater += ht;
        }
        return totalWater;
    }
    public void solve(int[] height, int mxl[], int mxr[]){
        int i=1;
        int j=height.length-2;
        mxl[0] = height[0];
        mxr[j+1] = height[height.length-1];
        while(i<height.length && j>=0){
            mxl[i] = Math.max(mxl[i-1], height[i]);
            mxr[j] = Math.max(mxr[j+1], height[j]);
            i++;
            j--;
        }
    }
    
}