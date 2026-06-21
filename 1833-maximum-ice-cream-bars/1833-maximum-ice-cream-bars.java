class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int cost : costs) {
            if (cost > max) {
                max = cost;
            }
        }
        int[] freq = new int[max + 1];
        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (freq[i] == 0) continue;
            
            if (coins < i) {
                break;
            }
            
            int buy = Math.min(freq[i], coins / i);
            count += buy;
            coins -= buy * i;
        }
        
        return count;
    }
}