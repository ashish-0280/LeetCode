class Solution {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        for(int num : nums){
            if(num > middle){
                return true;
            }
            if(num <= smallest){
                smallest = num;
            } else {
                middle = num;
            }
        }
        return false;
    }
}