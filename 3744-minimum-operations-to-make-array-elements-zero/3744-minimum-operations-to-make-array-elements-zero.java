class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for(int query[]: queries){
            ans += solve(query[0], query[1]);
        }
        return ans;
    }
    public long solve(int l, int r){
        long S = 0;
        long tmax = 0;
        
        // k is number of divisions needed
        for (int k = 1; ; k++) {
            long low = (long) Math.pow(4, k - 1);
            long high = (long) Math.pow(4, k) - 1;
            if (low > r) break; // no more numbers in this range
            
            long start = Math.max(l, low);
            long end = Math.min(r, high);
            
            if (start <= end) {
                long count = end - start + 1;
                S += count * k;
                tmax = k;
            }
        }
        
        long ceilHalf = ((S + 1) >> 1); // ceil(S/2)
        return Math.max(tmax, ceilHalf);
    }
}