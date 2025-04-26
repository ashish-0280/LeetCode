class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0; int j=0; int pdt = 1;
        int cnt = 0; int n = nums.length;
        while(j<n){
            pdt *= nums[j];
            while(pdt >= k){
                pdt = pdt/nums[i];
                i++;
                if(i == n){
                    return cnt;
                }
            }
            cnt += j-i+1;
            if(cnt < 0){
                return 0;
            }
            j++;
        }
        return cnt;
    }
}