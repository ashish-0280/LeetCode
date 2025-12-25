class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int n = happiness.length;
        Arrays.sort(happiness); int p = 0;
        for(int i=n-1; i>=0; i--){
            if(p == k || (happiness[i] - p <= 0)){
                break;
            }
            ans += (happiness[i] - p);
            p++;
        }
        return ans;
    }
}