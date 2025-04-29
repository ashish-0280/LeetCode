class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
        }
        long cnt = 0; int i=0; int j=0; int n=nums.length;
        while(j<n){
            if(nums[j] == max) k--;
            while(k <= 0){
                cnt += n-j;
                if(nums[i] == max) k++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}