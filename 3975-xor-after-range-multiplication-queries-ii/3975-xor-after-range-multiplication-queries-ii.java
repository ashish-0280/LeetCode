class Solution {
    static final long mod = 1_000_000_007L;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        Map<Long,Integer> map = new HashMap<>();

        // Compress queries into map
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            long key = 1L * l * 10000000000L + 1L * r * 100000L + k;

            map.put(key, (int)((1L * map.getOrDefault(key, 1) * v) % mod));
        }

        // Apply all queries
        for(long key : map.keySet()) {
            long L = key / 10000000000L;
            long R = (key / 100000L) % 100000; 
            long K = key % 100000;

            for(int i = (int)L; i <= (int)R; i += (int)K) {
                nums[i] = (int)((1L * nums[i] * map.get(key)) % mod);
            }
        }

        // Final XOR
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}