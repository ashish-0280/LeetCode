class Solution {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        for(int num: nums){
            int a = num%3;
            int b = 3 - a;
            cnt += Math.min(a, b);
        }
        return cnt;
    }
}