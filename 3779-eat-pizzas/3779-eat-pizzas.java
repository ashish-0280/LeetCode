class Solution {
    public long maxWeight(int[] pizzas) {
        long ans = 0;
        Arrays.sort(pizzas); int n = pizzas.length;
        int totalDays = n/4;
        int idx = n-1;

        for(int i=1; i<=totalDays; i=i+2){
            ans += pizzas[idx];
            idx--;
        }
        idx--;
        for(int i=2; i<=totalDays; i=i+2){
            ans += pizzas[idx];
            idx = idx-2;
        }
        return ans;
    }
}