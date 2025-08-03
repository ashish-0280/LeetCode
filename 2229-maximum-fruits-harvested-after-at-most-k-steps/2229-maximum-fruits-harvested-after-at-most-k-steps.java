class Solution {
    public int maxTotalFruits(int[][] fruits, int start, int k) {
        int max = 0, sum = 0, l = 0;

        for (int r = 0; r < fruits.length; r++) {
            sum += fruits[r][1];

            while (l <= r && !canReach(fruits[l][0], fruits[r][0], start, k)) {
                sum -= fruits[l++][1];
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    private boolean canReach(int left, int right, int start, int k) {
        if (right <= start) return start - left <= k;
        if (left >= start) return right - start <= k;

        int leftDist = start - left;
        int rightDist = right - start;

        return Math.min(2 * leftDist + rightDist, 2 * rightDist + leftDist) <= k;
    }
}
