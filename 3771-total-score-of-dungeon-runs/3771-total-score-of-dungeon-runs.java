class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long ans = 0;

        for (int i = 1; i < n; i++) {
            damage[i] += damage[i - 1];
        }

        for (int i = 1; i < n; i++) {
            int low = 0, high = i;

            while (low <= high) {
                int mid = (low + high) / 2;
                long dmg = damage[i] - (mid > 0 ? damage[mid - 1] : 0);

                if (hp - dmg >= requirement[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            ans += (i - high);
        }

        if (hp - damage[0] >= requirement[0]) ans++;

        return ans;
    }
}
