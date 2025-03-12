class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        if(k>colors.length) return 0;
        int n = colors.length + k -1; int cnt = 0;
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = colors[i%colors.length];
        }
        int n1 = colors.length;
        int i=0; int j=0;
        while(j<n){
            if(j>0 && arr[j-1] == arr[j]){
                i = j;
            }
            if(j-i+1 >= k){
                cnt++;
            }
            j++; 
        }
        return cnt;
    }
    public boolean solve(int arr[], int i, int j){
        for(int k=i; k<j; k++){
            if(arr[k] == arr[k+1]){
                return false;
            }
        }
        return true;
    }
}