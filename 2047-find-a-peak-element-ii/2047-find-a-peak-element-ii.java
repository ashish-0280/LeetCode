class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length; int n = mat[0].length;
        int i=0; int j = n-1; int row = 0;
        while(i <= j){
            int mid = (i+j)/2;
            int max = -1;
            for(int p=0; p<m; p++){
                if(max < mat[p][mid]){
                    max = mat[p][mid];
                    row = p;
                }
            }
            boolean isLeftSmaller = (mid == 0 || mat[row][mid-1] < max);
            boolean isRightSmaller = (mid == n-1 || mat[row][mid+1] < max);
            if(isLeftSmaller && isRightSmaller){
                return new int[]{row, mid};
            } else if(isLeftSmaller){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return new int[]{-1, -1};
    }
}