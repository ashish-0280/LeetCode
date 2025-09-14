class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int idx = 0;
        boolean result[] = new boolean[n];
        for(int i=1; i<=n; i++){
            while(idx < n && nums[idx] <= i){
                List<Integer> list = new ArrayList<>(set);
                for(int sum: list){
                    int newSum = sum + nums[idx];
                    if(newSum <= k) set.add(newSum);
                }
                idx++;
            }
            if(set.contains(k)){
                result[i-1] = true;
            } else {
                for(int p=idx; p<n; p++){
                    int right = p-idx+1;
                    int needed = k - (right * i);
                    if(set.contains(needed)){
                        result[i-1] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
}