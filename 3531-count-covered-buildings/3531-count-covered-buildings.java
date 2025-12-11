class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, int[]> rowToCol = new HashMap<>();
        Map<Integer, int[]> colToRow = new HashMap<>();
        
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            rowToCol.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            int arr[] = rowToCol.get(x);
            arr[0] = Math.min(arr[0], y); arr[1] = Math.max(arr[1], y);
            
            colToRow.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            int arr2[] = colToRow.get(y);
            arr2[0] = Math.min(arr2[0], x); arr2[1] = Math.max(arr2[1], x);
        }
        
        int cnt = 0;
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            
            int[] cols = rowToCol.get(x);
            int[] rows = colToRow.get(y);
            

            Integer down = cols[0];
            Integer up = cols[1];
            Integer right = rows[1];
            Integer left = rows[0];
            
            if (x > left && x < right && y < up && y > down) {
                cnt++;
            }
        }
        
        return cnt;
    }
}
