class Solution {
    public long numOfSubsequences(String s) {
        int n = s.length();
        int pre[] = new int[n];
        int suff[] = new int[n];

        for(int i=0; i<n; i++){
            if(i-1 >= 0) pre[i] = pre[i-1];
            if(s.charAt(i) == 'L'){
                pre[i]++;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(i+1 <= n-1) suff[i] = suff[i+1];
            if(s.charAt(i) == 'T'){
                suff[i]++;
            }
        }
        long best = 0, ans = 0, ansL = 0, ansT = 0;
        for(int i=0; i<n; i++){
            long x = i-1 >= 0 ? pre[i-1] : 0;
            long y = i+1 <= n-1 ? suff[i+1] : 0;

            if(s.charAt(i) == 'C'){
                ans += x * y;
                ansL += (x+1) * y;
                ansT += x * (y+1);
            }
            x = pre[i];
            best = Math.max(best, x * y);
        }
        return Math.max((best + ans), Math.max(ansL, ansT));
    }
}