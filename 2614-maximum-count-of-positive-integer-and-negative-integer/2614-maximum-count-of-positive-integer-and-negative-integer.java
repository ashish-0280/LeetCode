class Solution {
    public int maximumCount(int[] nums) {
        int cnt1 = 0; int cnt2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                cnt1++;
            }
            else if(nums[i] > 0){
                cnt2++;
            }
        }
        return Math.max(cnt1, cnt2);
    }
}