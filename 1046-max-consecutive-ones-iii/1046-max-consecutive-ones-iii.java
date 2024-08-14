class Solution {
    public int longestOnes(int[] nums, int k) {
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                cnt++;
            }
            if(cnt > k){
                while(j<=i && cnt > k){
                    if(nums[j] == 0){
                        cnt--;
                    }
                    j++;
                }
            }
            max = Math.max(max, i-j+1);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}