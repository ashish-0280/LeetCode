class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int steps = countSteps(curr, n);  

            if (steps <= k) {
                curr++;
                k -= steps;  
            } else {
                curr *= 10;
                k--;  
            }
        }

        return curr;  
    }

    public int countSteps(int curr, int n) {
        long first = curr;
        long last = curr;
        int steps = 0;

        while (first <= n) {
            steps += Math.min(n + 1, last + 1) - first;
            first *= 10;
            last = last * 10 + 9;
        }

        return steps;
    }
}
