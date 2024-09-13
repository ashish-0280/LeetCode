class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            ans[i] = help(arr, x, y);
        }
        return ans;
    }
    public int help(int arr[], int x, int y){
        int num = arr[x];
        for(int i=x+1; i<=y; i++){
            num = num ^ arr[i];
        }
        return num;
    }
}