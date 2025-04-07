class Solution {
    public boolean canPartition(int[] nums) {
        int S = summation(nums);
        if(S % 2 != 0){
            return false;
        }
        int target = S/2;
        int dp[][] = new int[nums.length+1][target+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return isSubsetSum(nums.length, nums, target, dp);
    }
     public Boolean isSubsetSum(int N, int arr[], int sum, int dp[][]){
        if(sum == 0){
            return true;
        }
        if(N == 0){
            return false;
        }
        
        if(dp[N][sum] != -1){
            return dp[N][sum] == 1;
        } 
        if(arr[N-1] > sum){
            boolean p = isSubsetSum(N-1, arr, sum, dp);
            if(p == true){
                dp[N][sum] = 1;
                return p;
            } else {
                dp[N][sum] = 0;
                return p;
            }
        } else {
            boolean take = isSubsetSum(N-1, arr, sum-arr[N-1], dp);
            boolean skip = isSubsetSum(N-1, arr, sum, dp);

            dp[N][sum] = (take || skip) ? 1 : 0;
            
        }
        
        return dp[N][sum] == 1;
    }
    public int summation(int arr[]){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}