class Solution {
    Integer dp[][];
    public int minimumDeleteSum(String s1, String s2) {
        dp = new Integer[s1.length()][s2.length()];
        return solve(s1, s2, 0, 0);
    }
    public int solve(String s1, String s2, int i, int j){
        if(i >= s1.length()){
            int sum = 0;
            for(int k=j; k<s2.length(); k++){
                sum += s2.charAt(k);
            }
            return sum;
        }
        if(j >= s2.length()){
            int sum = 0;
            for(int k=i; k<s1.length(); k++){
                sum += s1.charAt(k);
            }
            return sum;
        }
        if(dp[i][j] != null) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return solve(s1, s2, i+1, j+1);
        }
        int delete1 = s1.charAt(i) + solve(s1, s2, i+1, j);
        int delete2 = s2.charAt(j) + solve(s1, s2, i, j+1);
        
        return dp[i][j] = Math.min(delete1, delete2);
    }
}