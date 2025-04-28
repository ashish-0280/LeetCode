class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }
    public int solve(int nums[], int xor, int idx){
        if(idx >= nums.length){
            return xor;
        }
        int include = solve(nums, xor^nums[idx], idx+1);
        int exclude = solve(nums, xor, idx+1);
        return include + exclude;
    }
}