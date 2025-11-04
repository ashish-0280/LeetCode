class Solution {
    public long maxProduct(int[] nums) {
        int cnt = 0; int n = nums.length;
        for(int num: nums){
            if(num != 0) cnt++;
        }
        if(cnt < 2){
            return 0;
        }
        Arrays.sort(nums);
        long max = 1; long pdt1 = 1, pdt2 = 1, pdt3 = 1;
        pdt1 = pdt1 * nums[n-1] * nums[n-2];
        pdt1 = Math.abs(pdt1);
        pdt2 = pdt2 * nums[0] * nums[n-1];
        pdt2 = Math.abs(pdt2);
        pdt3 = pdt3 * nums[0] * nums[1];
        pdt3 = Math.abs(pdt3);
        max = Math.max(pdt1, Math.max(pdt2, pdt3));
        return max*100000;
    }
}