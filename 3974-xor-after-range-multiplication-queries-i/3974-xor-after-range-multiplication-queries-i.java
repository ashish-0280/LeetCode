class Solution {
    static int mod = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int query[]: queries){
            for(int i=query[0]; i<=query[1]; i+=query[2]){
                long dumy = (long)nums[i];
                dumy = (dumy * query[3]) % mod;
                nums[i] = (int)dumy;
            }
        }
        int ans = 0;
        for(int num: nums){
            ans ^= num;
        }
        return ans;
    }
}