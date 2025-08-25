class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[n * m];
        
        int row = 0, col = 0, d = 1;
        
        for (int i = 0; i < n * m; i++) {
            ans[i] = mat[row][col];
            
            row -= d;
            col += d;
            
            if(row >= n){
                row = n-1; col += 2; d = -d;
            }
            if(col >= m){
                col = m-1; row += 2; d = -d;
            }
            if(row < 0){
                row = 0; d = -d;
            }
            if(col < 0){
                col = 0; d = -d;
            }
        }
        
        return ans;
    }
}
