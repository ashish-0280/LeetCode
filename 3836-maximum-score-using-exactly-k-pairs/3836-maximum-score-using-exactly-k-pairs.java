class Solution {
    Long dp[][][];
    public long maxScore(int[] nums1, int[] nums2, int k) {
        dp = new Long[nums1.length][nums2.length][k+1];
        return solve(nums1, nums2, k, 0, 0);
    }
    public long solve(int nums1[], int nums2[], int k, int i, int j){
        if(k == 0) return 0;
        if(i>=nums1.length || j >= nums2.length){
            return Long.MIN_VALUE;
        }

        if(dp[i][j][k] != null) return dp[i][j][k];

        long take = solve(nums1, nums2, k-1, i+1, j+1);
        if(take != Long.MIN_VALUE){
            take += (long)nums1[i] * nums2[j];
        }
        long skip1 = solve(nums1, nums2, k, i+1, j);
        long skip2 = solve(nums1, nums2, k, i, j+1);
        return dp[i][j][k] = Math.max(take, Math.max(skip1, skip2));
    }
}