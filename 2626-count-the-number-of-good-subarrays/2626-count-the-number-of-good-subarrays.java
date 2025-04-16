class Solution {
    public long countGood(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int i=0; int j=0; int pairs = 0; long cnt = 0;
        while(j < nums.length){
            int num = nums[j];
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.containsKey(num)){
                pairs -= calculatePairs(map.get(num)-1);
                pairs += calculatePairs(map.get(num));
            } else {
                pairs += calculatePairs(map.get(num));
            }
            while(pairs >= k){
                cnt += nums.length - j;   
                int pair1 = calculatePairs(map.get(nums[i])-1);
                int pair2 = calculatePairs(map.get(nums[i]));
                pairs = pairs-pair2;
                pairs = pairs+pair1;
                map.put(nums[i], map.get(nums[i])-1);
                i++;
            }
            j++;
        }
        return cnt;
    }
    public int calculatePairs(int n){
        n = n-1;
        int p = (n*(n+1))/2;
        if(p<0) return 0;
        return p;
    }
}