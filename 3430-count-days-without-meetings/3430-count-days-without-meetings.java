class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        int totalDays = 0;
        int prevEnd = -1; int prevStart = -1;
        for(int row[]: meetings){
            int start = row[0];
            int end = row[1];
                if(start > prevEnd){
                    totalDays += end - start + 1;
                    prevStart = prevStart;
                    prevEnd = end;
                } else if(end > prevEnd){
                totalDays += end - prevEnd;
                prevEnd = end;
            }
        }
        return days - totalDays;
    }
}