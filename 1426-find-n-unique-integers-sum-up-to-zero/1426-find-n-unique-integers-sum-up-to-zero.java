class Solution {
    public int[] sumZero(int n) {
        int ans[] = new int[n];
        int low = 0; int high = n-1; int num = 1;
        while(low < high){
            ans[low] = num;
            ans[high] = -num;
            num++; low++; high--;
        }
        return ans;
    }
}