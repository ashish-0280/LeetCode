class Solution {
    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        int n = nums.length;
        int nextBreak[] = new int[n];
        nextBreak[n-1] = n;
        for(int i=n-2; i>=0; i--){
            if(nums[i] <= nums[i+1]){
                nextBreak[i] = nextBreak[i+1];
            } else {
                nextBreak[i] = i+1;
            }
        }
        long count[] = new long[n];
        count[0] = 1; long p = 2;
        for(int i=1; i<n; i++){
            if(nextBreak[i] == nextBreak[i-1]){
                count[i] = count[i-1] + p;
            } else {
                p = 1;
                count[i] = count[i-1] + p;
            }
            p++;
        }

        long ans[] = new long[queries.length]; int i=0;
        for(int query[]: queries){
            int l = query[0]; int r = query[1];
            int cut = Math.min(nextBreak[l], r+1);
            if(cut > 0){
                ans[i] = count[r] - count[cut-1];
            } else {
                ans[i] = count[r];
            }
            long left = cut - l;
            ans[i] += (left * (left+1))/2;
            i++;
        }
        return ans;
    }
}