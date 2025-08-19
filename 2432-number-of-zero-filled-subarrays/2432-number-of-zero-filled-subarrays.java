class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length; long ans = 0;
        int i=0;
        long cnt = 0;
        while(i < n){
            while(i < n && nums[i] == 0){
                cnt++;
                if(i+1 < n){
                    if(nums[i+1] != 0){
                        ans += (cnt * (cnt+1))/2;
                        cnt = 0;
                        break;
                    }
                }
                i++;
            }
            i++;
        }
        ans += (cnt * (cnt+1))/2;
        return ans;
    }
}