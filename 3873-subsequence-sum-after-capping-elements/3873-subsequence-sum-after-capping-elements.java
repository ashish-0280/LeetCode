class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] result = new boolean[n];
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            while (idx < n && nums[idx] <= i) {
                List<Integer> current = new ArrayList<>(set);
                for (int sum : current) {
                    if(sum + nums[idx] <= k){
                        set.add(sum+nums[idx]);
                    }
                }
                idx++;
            }
            if (set.contains(k)) {
                result[i - 1] = true;
            } else {
                for(int p=idx; p<n; p++){
                    if(set.contains(k-(p-idx+1)*i)){ 
                        result[i-1]=true; 
                        break;
                    } 
                }
            }
        }
        return result;
    }
}