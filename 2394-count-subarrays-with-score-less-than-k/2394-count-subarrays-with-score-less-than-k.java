class Solution {
    public long countSubarrays(int[] nums, long k) {
        long cnt = 0;
        int n = nums.length;
        int i=0; int j=0; long sum = 0;
        while(j < n){
            sum += nums[j];
            int size = j-i+1;
            long check = sum * size;
            while(check >= k){
                sum -= nums[i];
                i++;
                size = j-i+1;
                check = sum * size;
            }
            cnt += j-i+1;
            j++;
        }
        return cnt;
    }
}