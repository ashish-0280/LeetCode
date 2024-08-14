class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
    }
    public int atMost(int nums[], int k){
        int count = 0;
        int left = 0;
        int cnt = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right]%2 != 0){
                count++;
            }
                while(count > k){
                    if(nums[left]%2 != 0){
                        count--;
                    }
                    left++;
                }
            cnt += right-left+1;
        }
        return cnt;
    }
}