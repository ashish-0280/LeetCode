class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;
        
        if (n == 1) {
            long sum = 0;
            for (int i = 0; i < m; i++) {
                sum += units[i][0];
            }
            return sum;
        }
        
        long sumSecondMin = 0;
        int minOfSecondMin = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < m; i++) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            
            for (int j = 0; j < n; j++) {
                int val = units[i][j];
                if (val < first) {
                    second = first;
                    first = val;
                } else if (val < second) {
                    second = val;
                }
            }
            
            sumSecondMin += second;
            if (second < minOfSecondMin) {
                minOfSecondMin = second;
            }
            if (first < min) {
                min = first;
            }
        }
        
        return sumSecondMin - minOfSecondMin + min;
    }
}