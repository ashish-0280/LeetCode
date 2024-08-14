class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        // int j = 0;
        // for(int i=0; i<nums.length; i++){
        //     sum += nums[i];
        //     if(sum > goal){
        //         while(j<i && sum >= goal){
        //             if(sum == goal){
        //                 count++;
        //             }
        //             sum = sum - nums[j];
        //             j++;
        //         }
        //     }
        //     if(sum == goal){
        //         count++;
        //     }
        // }
        for(int i=0; i<nums.length; i++){
            sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum == goal){
                    count++;
                }
            }
        }
        return count;
    }
}