class Solution {
    public int minOperations(int[] nums, int k) {
        int ops = 0;
        for(int num: nums){
            ops += num;
        }
        return ops%k;
    }
}