class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int ans = 2;
        int a = intervals[0][1]-1;
        int b = intervals[0][1];
        for(int interval[]: intervals){
            if(interval[0] > b){
                a = interval[1] - 1;
                b = interval[1];
                ans += 2;
            } else if(interval[0] > a && interval[0] <= b){
                a = b;
                b = interval[1];
                ans++;
            }
        }
        return ans;
    }
}