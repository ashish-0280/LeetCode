class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int num = nums[i];
            int rem = 0; int sum = 0;
            while(num != 0){
                rem = num % 10;
                num = num/10;
                sum += rem;
            }
            if(map.containsKey(sum)){
                int prev = map.get(sum);
                int curr = nums[i];
                max = Math.max(max, prev+curr);
                if(curr>prev){
                    map.put(sum, curr);
                }
            } else {
                map.put(sum, nums[i]);
            }
        }
        return max;
    }
}