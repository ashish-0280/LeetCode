class Solution {
    int MOD = 1_000_000_007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long current = 0;

        for (int i = 1; i < n; i++) {
            int num = map.getOrDefault(i - delay, 0);
            current += num;
            int f = map.getOrDefault(i - forget, 0) % MOD;
            current -= f;
            map.put(i, (int) (current % MOD));
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += map.getOrDefault(i, 0);
            int f = map.getOrDefault(i - forget, 0);
            count -= f;
        }

        return (int) ((count % MOD + MOD) % MOD);
    }
}
