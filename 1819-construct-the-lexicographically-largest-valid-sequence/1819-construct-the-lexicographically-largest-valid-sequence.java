class Solution {
    public int[] constructDistancedSequence(int n) {
        int arr[] = new int[2*(n-1) + 1];
        boolean vis[] = new boolean[n+1];
        solve(arr, n, 0, vis);
        return arr;
    }
    public boolean solve(int arr[], int n, int idx, boolean vis[]){
        if(idx == arr.length){
            return true;
        }
        if(arr[idx] != 0){
            return solve(arr, n, idx+1, vis);
        }
        for(int i=n; i>0; i--){
            if(!vis[i]){
                if(i==1){
                    arr[idx] = 1;
                    vis[i] = true;
                    if(solve(arr, n, idx+1, vis)){
                        return true;
                    }
                    arr[idx] = 0;
                    vis[i] = false;
                }
                else if(idx+i<arr.length && arr[idx+i] == 0){
                    arr[idx] = i;
                    arr[idx + i] = i;
                    vis[i] = true;
                    if(solve(arr, n, idx+1, vis)){
                        return true;
                    }
                    vis[i] = false;
                    arr[idx] = 0;
                    arr[idx+i] = 0;
                }
            }
        }
        return false;
    }
}