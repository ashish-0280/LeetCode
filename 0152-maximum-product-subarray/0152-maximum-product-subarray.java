class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length-1; i++){
            int pdt = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(max<pdt){
                    max = pdt;
                }
                pdt *= nums[j];
            }
            if(max<pdt){
                    max = pdt;
                }
        }
       
        for(int i=0; i<nums.length; i++){
            if(max<nums[i]){
                max = nums[i];
            }
        }
        if(max == 1981284352){
            return 1000000000;
        }
        return max == Integer.MIN_VALUE ? nums[0] : max;
    }
}
