class Solution {
    public int countPairs(int[] nums, int k) {
        int cnt = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(solve(i, j, nums, k)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean solve(int i, int j, int nums[], int k){
        return (((i*j) % k == 0) && (nums[i] == nums[j]));
    }
}