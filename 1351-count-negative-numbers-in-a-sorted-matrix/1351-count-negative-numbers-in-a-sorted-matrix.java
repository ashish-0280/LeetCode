class Solution {
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        int n = grid.length; int m = grid[0].length;
        for(int g[]: grid){
            int idx = search(g, m);
            if(idx == m) continue;
            cnt += m - idx;
        }
        return cnt;
    }
    public int search(int arr[], int n){
        int low = 0; int high = n-1; int ans = n;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] < 0){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}