class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights); // Minimum possible capacity
        int high = getSum(weights); // Maximum possible capacity

        while (low <= high) {
            int mid = (low + high) / 2;
            if (countDays(weights, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int getMax(int[] weights) {
        int max = 0;
        for (int w : weights) {
            max = Math.max(max, w);
        }
        return max;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }

    private int countDays(int[] weights, int capacity) {
        int days = 1;
        int load = 0;
        for (int w : weights) {
            if (load + w > capacity) {
                days++;
                load = 0;
            }
            load += w;
        }
        return days;
    }
}
