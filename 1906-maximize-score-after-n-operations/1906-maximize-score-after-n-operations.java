class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        Integer dp[] = new Integer[1<<n];
        return solve(0, nums, nums.length, 1, dp);
    }
    public int solve(int mask, int nums[], int n, int cnt, Integer dp[]){
        if(mask == (1<<n)-1){
            return 0;
        }
        if(dp[mask] != null) return dp[mask];
        int maxScore = 0;
        for(int i=0; i<n; i++){
            if((mask & (1<<i)) == 0){
                for(int j=i+1; j<n; j++){
                    if((mask & (1<<j)) == 0){
                        int newMask = mask | (1<<i) | (1<<j);
                        int ans = cnt * gcd(nums[i], nums[j]) + solve(newMask, nums, nums.length, cnt+1, dp);
                        maxScore = Math.max(maxScore, ans);
                    }
                }
            }
        }
        return dp[mask] = maxScore;
    }
    public int gcd(int a, int b) {
        if (a == 0) return Math.abs(b);
        if (b == 0) return Math.abs(a);

        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}