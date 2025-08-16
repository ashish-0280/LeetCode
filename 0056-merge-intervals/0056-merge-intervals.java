class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});
        int p = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= list.get(p)[1]){
                if(intervals[i][1] <= list.get(p)[1]){
                    continue;
                }
                list.get(p)[1] = intervals[i][1];
            } else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                p++;
            }
        }
        int ans[][] = new int[list.size()][2];
        int i=0;
        for(int row[]: list){
            ans[i][0] = row[0]; ans[i][1] = row[1];
            i++;
        }
        return ans;
    }
}