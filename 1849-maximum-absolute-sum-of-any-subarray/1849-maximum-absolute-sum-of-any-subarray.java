class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prefixSum = 0; int sum = 0;
        int min = 0;
        int max = 0;
        for(int num : nums){
            prefixSum += num;
            min = Math.min(min, prefixSum);
            max = Math.max(max, prefixSum);
            if(prefixSum < 0){
                int x = Math.abs(prefixSum-max);
                sum = Math.max(sum, x);
            } else {
                int y = Math.abs(prefixSum-min);
                sum = Math.max(sum, y);
            }
        }
        return sum;
    }
}