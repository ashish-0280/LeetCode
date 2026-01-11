class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<=n; i++){
            int current = (i == n) ? 0 : heights[i];
            while(!stk.isEmpty() && current < heights[stk.peek()]){
                int height = heights[stk.pop()];
                int left = (stk.isEmpty()) ? -1 : stk.peek();
                int width = i - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stk.push(i);
        }
        return maxArea;
    }
}