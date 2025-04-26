class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0; int j=0; int pdt = 1;
        int cnt = 0; int n = nums.length;
        if(solve(nums)){
            if(nums[0] >= k){
                return 0;
            }
        }
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
            j++;
        }
        return cnt;
    }
    public boolean solve(int nums[]){
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }
}