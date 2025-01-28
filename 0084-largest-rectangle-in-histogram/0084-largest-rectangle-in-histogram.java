class Solution {
    public int largestRectangleArea(int[] heights) {
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];
        NSR(heights, nsr);
        NSL(heights, nsl);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            int w = Math.abs(nsr[i]-nsl[i]-1);
            int area = heights[i] * w;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public void NSR(int arr[], int nsr[]){
        Stack<Integer> s = new Stack<>();
        int i = arr.length-1;
        while (i >= 0) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            }
            else if (arr[s.peek()] < arr[i]) {
                nsr[i] = s.peek();
            }
            s.push(i);
            i--;
        }
    }
    public void NSL(int arr[], int nsl[]) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while (i < arr.length) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            }
            else if (arr[s.peek()] < arr[i]) {
                nsl[i] = s.peek();
            }
            s.push(i);
            i++;
        }
    }
}