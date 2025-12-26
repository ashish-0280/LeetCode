class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] prefixN = new int[n + 1];  
        int[] suffixY = new int[n + 1];  

        for (int i = 1; i <= n; i++) {
            prefixN[i] = prefixN[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                prefixN[i]++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixY[i] = suffixY[i + 1];
            if (customers.charAt(i) == 'Y') {
                suffixY[i]++;
            }
        }

        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

        for (int j = 0; j <= n; j++) {
            int penalty = prefixN[j] + suffixY[j];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j;
            }
        }

        return bestHour;
    }
}