class Solution {
    public int countPartitions(int[] nums) {
        int sumLeft = 0;
        int sumRight = sum(nums); int cnt = 0;
        for(int i=0; i<nums.length-1; i++){
            sumLeft += nums[i];
            sumRight -= nums[i];
            if((sumRight - sumLeft) % 2 == 0) cnt++;
        }
        return cnt;
    }
    public int sum(int nums[]){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return sum;
    }
}