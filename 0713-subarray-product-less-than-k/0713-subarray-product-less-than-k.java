class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int i=0; int j=0; int pdt = 1;
        int cnt = 0; int n = nums.length;
        while(j<n){
            pdt *= nums[j];
            while(pdt >= k){
                pdt = pdt/nums[i];
                i++;
            }
            cnt += j-i+1;
            j++;
        }
        return cnt;
    }
}