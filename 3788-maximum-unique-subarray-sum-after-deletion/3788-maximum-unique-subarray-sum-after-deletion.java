class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int maxNegative = Integer.MIN_VALUE;
        for(int num: nums){
            if(num > 0){
                set.add(num);
            } else {
                maxNegative = Math.max(num, maxNegative);
            }
        }
        int sum = 0;
        for(int num: set){
            sum += num;
        }
        if(set.size() > 0){
            return sum;
        }
        return maxNegative;
    }
}