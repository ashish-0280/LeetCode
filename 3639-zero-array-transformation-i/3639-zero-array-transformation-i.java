class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int diff[] = new int[nums.length+1];
        for(int row[]: queries){
            int l = row[0];
            int r = row[1];
            diff[l]++; diff[r+1]--;
        }
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            cnt += diff[i];
            if(cnt < nums[i]){
                return false;
            }
        }
        return true;
    }
}