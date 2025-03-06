class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int curr = 0;
        int p = 0;
        int n = grid.length;

        int arr[] = new int[2];
        int arr1[] = new int[n*n];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                arr1[p] = grid[i][j];
                p++;
            }
        }
        Arrays.sort(arr1);
        for(int i=0; i<arr1.length-1; i++){
            if(arr1[i+1]-arr1[i] == 2){
                arr[1] = arr1[i]+1;
                curr = 5;
            } else if(arr1[0] != 1){
                arr[1] = 1;
                curr = 5;
            }
           if(arr1[i+1]-arr1[i] == 0){
                arr[0] = arr1[i];
            }
        }
        if(curr != 5){
            arr[1] = n*n;
        }
        return arr;
    }
}