class Solution {
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int [2];
        for(int i=1; i<n; i++){
            String s1 = String.valueOf(i);
            String s2 = String.valueOf(n - i);
            if(s1.indexOf("0") == -1 && s2.indexOf("0") == -1){
                ans[0] = i; ans[1] = n-i;
                return ans;
            }
        }
        return ans;
    }
}