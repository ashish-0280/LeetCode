class Solution {
    public int maximumAND(int[] nums, int k, int m) {
        long ans = 0;
        for(int i=30; i>=0; i--){
            long mask = ans | (1l << i);
            long costs[] = new long[nums.length];
            for(int idx = 0; idx < nums.length; idx++){
                costs[idx] = minCost(nums[idx], mask);
            }
            Arrays.sort(costs);
            long operations = 0;
            for(int j=0; j<m; j++){
                operations += costs[j];
                if(operations > k){
                    break;
                }
            }
            if(operations <= k){
                ans = mask;
            }
            
        }
        return (int)ans;
    }
    public long minCost(int num, long target){
        if((num & target) == target) return 0;
        int p = -1;
        for(int i=30; i>=0; i--){
            if((num & (1 << i)) == 0 && (target & (1 << i)) != 0){
                p = i;
                break;
            }
        }
        long mask = (1 << (p+1)) - 1;
        long left = (~mask & num);
        long right = (mask & target);
        long finalVal =  left | right;
        return finalVal - num;
    }
}