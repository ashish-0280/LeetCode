class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length-1;
        int maxWater = 0;

        while(lp<=rp){
            int h = Math.min(height[lp], height[rp]);
            int width = rp-lp;
            int currWater = h*width;
            maxWater = Math.max(currWater, maxWater);
            if(height[lp]>height[rp]){
                rp--;
            } else {
                lp++;
            }
        }
        return maxWater;
    }
}