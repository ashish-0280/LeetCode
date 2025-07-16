class Solution {
    public int maximumLength(int[] nums) {
        int cnt1 = 0; int cnt2 = 0; boolean even = false; boolean evenCurr = false;
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
             if(curr%2 == 0){
                 evenCurr = true;
             } else {
                 evenCurr = false;
             }
            if(even == evenCurr){
                cnt1++; even = !even;
            }
        }
        even = true;
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
             if(curr%2 == 0){
                 evenCurr = true;
             } else {
                 evenCurr = false;
             }
            if(even == evenCurr){
                cnt2++; even = !even;
            }
        }
        int cnt3 = 0; int cnt4 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 == 0){
                cnt3++;
            } else {
                cnt4++;
            }
        }
        return Math.max(cnt1, Math.max(cnt2, Math.max(cnt3, cnt4)));
    }
}