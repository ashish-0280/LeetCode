class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=n-1; i>=2; i--){
            int x = nums[i-1] + nums[i-2];
            if(x > nums[i]){
                return x + nums[i];
            }
        }
        return 0;
    }
}