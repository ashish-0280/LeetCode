class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int ans[][] = new int[m][n];
        if(m*n != original.length){
            return new int[0][0];
        }
        int p=0;
        int q=0;
        for(int i=0; i<original.length; i++){
            ans[p][q] = original[i];
            q++;
            if(q%n == 0){
                p++;
                q = 0;
            }
        }
        return ans;
    }
}