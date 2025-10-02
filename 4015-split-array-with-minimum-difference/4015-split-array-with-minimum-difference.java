class Solution {
    public long splitArray(int[] nums) {
        long ans = Long.MAX_VALUE;
        int n = nums.length;
        long prefixSum[] = new long[n];
        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i]; 
        }
        long suffixSum[] = new long[n];
        suffixSum[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffixSum[i] = suffixSum[i+1] + nums[i];
        }

        boolean b1[] = new boolean[n]; 
        b1[0] = true;

        for(int i=1; i<n; i++){
            if(nums[i] <= nums[i-1]){
                break;
            }
            
            b1[i] = true;
        }
        
        boolean b2[] = new boolean[n]; 
        b2[n-1] = true;

        for(int i=n-2; i>=0; i--){
            if(nums[i] <= nums[i+1]){
                break;
            }
                   
            b2[i] = true;
        }
        for(int i=0; i<n-1; i++){
            if(b1[i] && b2[i+1]){
                ans = Math.min(ans, Math.abs(prefixSum[i] - suffixSum[i+1]));
            }
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}