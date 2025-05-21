class Solution {
    public void setZeroes(int[][] matrix) {
        int count = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    count++;
                }
            }
        }
        int row[] = new int[count];
        int col[] = new int[count];
        int p=0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[p] = i;
                    col[p] = j;
                    p++;
                }
            }
        }
        for(int a=0; a<matrix[0].length; a++){
            for(int b=0; b<row.length; b++){
                matrix[row[b]][a] = 0;
            }
        }
        for(int a=0; a<matrix.length; a++){
            for(int b=0; b<col.length; b++){
                matrix[a][col[b]] = 0;
            }
        }
    }
}