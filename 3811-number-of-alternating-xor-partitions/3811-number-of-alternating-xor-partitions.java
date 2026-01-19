class Solution {
    int MOD = 1000000007;
    public int alternatingXOR(int[] nums, int target1, int target2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        map2.put(0, 1);
        int xor = 0,  ans = 0;

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            xor = xor ^ num;
            int endsAtTarget1 = map2.getOrDefault(xor ^ target1, 0);
            int endsAtTarget2 = map1.getOrDefault(xor ^ target2, 0);
            map1.put(xor, (map1.getOrDefault(xor, 0) + endsAtTarget1) % MOD);
            map2.put(xor, (map2.getOrDefault(xor, 0) + endsAtTarget2) % MOD);
            if(i==nums.length-1) ans = (endsAtTarget1 + endsAtTarget2) % MOD;
        }
        return ans;
    }
}