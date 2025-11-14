class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int arr[][] = new int[n+1][n+1];
        for(int query[]: queries){
            int r1 = query[0], c1 = query[1], r2 = query[2], c2 = query[3];
            arr[r1][c1] += 1;
            if(c2 + 1 < n){
                arr[r1][c2+1] -= 1;
            }
            if(r2 + 1 < n){
                arr[r2+1][c1] -= 1;
            }
            if(r2+1 < n && c2+1 < n){
                arr[r2+1][c2+1] += 1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=1; j<n; j++){
                arr[i][j] += arr[i][j-1];
            }
        }
        for(int j=0; j<n; j++){
            for(int i=1; i<n; i++){
                arr[i][j] += arr[i-1][j];
            }
        }
        int ans[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = arr[i][j];
            }
        }
        return ans;
    }
}