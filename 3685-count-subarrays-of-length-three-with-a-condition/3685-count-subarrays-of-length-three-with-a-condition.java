class Solution {
    public int countSubarrays(int[] nums) {
        int cnt = 0;
        int j=2; int num0 = -1; int num1 = nums[0];
        int num2 = nums[1];
        int n = nums.length;
        while(j < n){
            num0 = num1;
            num1 = num2;
            num2 = nums[j];
            float div = (float)num1/2;
            if((float)(num0+num2) == div) cnt++;
            j++;
        }
        return cnt;
    }
}