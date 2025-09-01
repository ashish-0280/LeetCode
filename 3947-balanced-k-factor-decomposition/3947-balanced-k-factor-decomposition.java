class Solution {
    List<Integer> bestSplit = new ArrayList<>();
    int minDiff = Integer.MAX_VALUE;
    List<Integer> divisors = new ArrayList<>();

    public int[] minDifference(int n, int k) {
        // Step 1: Find all divisors of n
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);

        // Step 2: Start the recursive search
        backtrack(n, k, new ArrayList<>(), 0);
        int ans[] = new int[bestSplit.size()];
        for(int i=0; i<bestSplit.size(); i++){
            ans[i] = bestSplit.get(i);
        }
        return ans;
    }

    private void backtrack(int remainingN, int remainingK, List<Integer> currentSplit, int startDivisorIndex) {
        if (remainingK == 0) {
            if (remainingN == 1) {
                int maxVal = Collections.max(currentSplit);
                int minVal = Collections.min(currentSplit);
                int diff = maxVal - minVal;
                
                if (diff < minDiff) {
                    minDiff = diff;
                    bestSplit = new ArrayList<>(currentSplit);
                }
            }
            return;
        }

        for (int i = startDivisorIndex; i < divisors.size(); i++) {
            int divisor = divisors.get(i);
            
            if (remainingN % divisor == 0) {
                currentSplit.add(divisor);
                backtrack(remainingN / divisor, remainingK - 1, currentSplit, i);
                currentSplit.remove(currentSplit.size() - 1);
            }
        }
    }
}