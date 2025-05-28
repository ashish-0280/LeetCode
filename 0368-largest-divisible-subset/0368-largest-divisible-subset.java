class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int hash[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=0; i<nums.length; i++){
            hash[i] = i;
            for(int prev_idx=0; prev_idx<=i-1; prev_idx++){
                if(nums[i]%nums[prev_idx] == 0 && dp[i] < 1+dp[prev_idx]){
                    dp[i] = 1+dp[prev_idx];
                    hash[i] = prev_idx;
                }
            }
        }
        int max = Integer.MIN_VALUE; int idx = 0;
        for(int i=0; i<dp.length; i++){
            if(max < dp[i]){
                max = dp[i];
                idx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[idx]);
        int lastIndex = idx;
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        return list;
    }
}