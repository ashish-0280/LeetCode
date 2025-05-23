class Solution {
    Integer dp[][];
    public int minCut(String s) {
        dp = new Integer[s.length()][s.length()];
        return solve(s.toCharArray(), 0, s.length()-1);
    }
    public int solve(char arr[], int i, int j){
        if(i >= j) return 0;
        if(isPallindrome(arr, i, j)) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            if(isPallindrome(arr, i, k)){
                int right = 1 + solve(arr, k+1, j);
                ans = Math.min(ans, right);
            }
        }
        return dp[i][j] = ans;
    }
    public boolean isPallindrome(char arr[], int i, int j){
        while(i <= j){
            if(arr[i] != arr[j]) return false;
            i++; j--;
        }
        return true;
    }
}