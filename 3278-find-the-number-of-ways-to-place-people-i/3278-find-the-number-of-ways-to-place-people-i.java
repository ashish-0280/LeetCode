class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? 
            b[1] - a[1] : a[0] - b[0]);
        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            int bound = Integer.MIN_VALUE, top = y1;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                if (y2 <= top && y2 > bound) {
                    cnt++;
                    bound = y2;
                    if (y2 == top) top--;
                }
            }
        }
        return cnt;
    }
}