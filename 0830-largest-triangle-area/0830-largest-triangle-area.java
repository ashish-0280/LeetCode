class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for(int p1[]: points){
            for(int p2[]: points){
                for(int p3[]: points){
                    maxArea = Math.max(maxArea, 0.5*(p1[0]*(p2[1] - p3[1]) + p2[0]*(p3[1] - p1[1]) + p3[0]*(p1[1] - p2[1])));
                }
            }
        }
        return maxArea;
    }
}