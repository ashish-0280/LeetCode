class Solution {
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int [2];
        for(int i=1; i<n; i++){
            if(!solve(i) && !solve(n-i)){
                ans[0] = i; ans[1] = n-i;
                return ans;
            }
        }
        return ans;
    }
    public boolean solve(int x){
        while(x > 0){
            if(x % 10 == 0){
                return true;
            }
            x = x/10;
        }
        return false;
    }

}