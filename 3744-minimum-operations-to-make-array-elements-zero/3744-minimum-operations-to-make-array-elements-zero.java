class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for(int query[]: queries){
            long steps = solve(query[0], query[1]);
            ans += (steps+1)/2;
        }
        return ans;
    }
    public long solve(int l, int r){
        long sum = 0;
        long low = 1; long k = 1; 
        while(k > 0){
            if(low > r) break;
            long high = 4*low - 1;
            long start = Math.max(l, low);
            long end = Math.min(r, high);
            if(start <= end){
                sum += (end - start + 1) * k;
            }
            k++;
            low *= 4;
        }
        return sum;
    }
}