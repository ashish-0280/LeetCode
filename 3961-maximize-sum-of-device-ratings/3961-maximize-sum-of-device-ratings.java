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
        
        long sumSecondMins = 0;
        int minOfSecondMins = Integer.MAX_VALUE;
        int globalMin = Integer.MAX_VALUE;
        
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
            
            sumSecondMins += second;
            if (second < minOfSecondMins) {
                minOfSecondMins = second;
            }
            if (first < globalMin) {
                globalMin = first;
            }
        }
        
        return sumSecondMins - minOfSecondMins + globalMin;
    }
}