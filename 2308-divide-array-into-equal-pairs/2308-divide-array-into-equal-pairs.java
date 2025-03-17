class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int i=0; int j=1;
        while(j<nums.length){
            if(nums[i] != nums[j]){
                return false;
            }
            i++; i++;
            j++; j++;
        }
        return true;
    }
}