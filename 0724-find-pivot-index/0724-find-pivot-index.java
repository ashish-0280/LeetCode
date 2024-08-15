class Solution {
    public int pivotIndex(int[] nums) {
        int pre[] = new int[nums.length];
        int suf[] = new int[nums.length];
        pre[0] = 0;
        for(int i=0; i<nums.length-1; i++){
            pre[i+1] = nums[i] + pre[i];
        }
        suf[nums.length-1] = 0;
        for(int i=nums.length-1; i>0; i--){
            suf[i-1] = nums[i] + suf[i];
        }
        for(int i=0; i<nums.length; i++){
            if(pre[i] == suf[i]){
                return i;
            }
        }
        return -1;
    }
}