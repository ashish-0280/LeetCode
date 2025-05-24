class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (n == 0) return 0;
        if (k == 1) return n;

        String key = k + "," + n;
        if (memo.containsKey(key)) return memo.get(key);

        int low = 1, high = n;
        int result = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            int broken = dp(k - 1, mid - 1);     
            int notBroken = dp(k, n - mid);     

            int worst = 1 + Math.max(broken, notBroken);

            if (broken > notBroken) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            result = Math.min(result, worst);
        }

        memo.put(key, result);
        return result;
    }
}
