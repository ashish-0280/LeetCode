class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;
        for(int num: nums){
            maxOr = maxOr | num;
        }
        return solve(nums, maxOr, 0, 0);
    }
    public int solve(int nums[], int target, int idx, int temp){
        if(idx == nums.length){
            return target == temp ? 1 : 0;
        }
        int pick = solve(nums, target, idx+1, temp | nums[idx]);
        int notPick =  solve(nums, target, idx+1, temp);
        return pick + notPick;
    }
}