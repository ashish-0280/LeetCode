class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length; int m = mat[0].length;
        int rowSum[][] = new int[n][m+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                rowSum[i][j+1] = rowSum[i][j] + mat[i][j];
            }
        }
        int low = 1; int high = Math.min(m, n);
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            boolean found = false;
            for(int i=0; i+mid<=n; i++){
                for(int j=0; j+mid<=m; j++){
                    if(check(mat, mid, threshold, rowSum, i, j)){
                        found = true;
                        break;
                    } 
                }
            }
            if(found){
                ans = mid;
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public boolean check(int mat[][], int size, int threshold, int rowSum[][], int row, int col){
        int sum = 0;
        for(int i=row; i<row+size; i++){
            sum += rowSum[i][col + size] - rowSum[i][col];
            if(sum > threshold) return false;
        }
        return true;
    }
}