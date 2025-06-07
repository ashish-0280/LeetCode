class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0; int col = n-1;
        while(row<=m-1 && col >= 0){
            if(row<=m-1 && col >= 0 && matrix[row][col] == target){
                return true;
            } else if(row<=m-1 && col >= 0 && matrix[row][col] > target){
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}