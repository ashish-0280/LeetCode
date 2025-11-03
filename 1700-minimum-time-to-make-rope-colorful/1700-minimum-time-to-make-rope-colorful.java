class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int total = neededTime[0]; int max = neededTime[0]; int ans = 0;
        for(int i=1; i<n; i++){
            if(colors.charAt(i) != colors.charAt(i-1)){
                ans += total - max;
                total = 0;
                max = 0;
            }
            total += neededTime[i];
            max = Math.max(max, neededTime[i]);
        }
        ans += total - max;
        return ans;
    }
}