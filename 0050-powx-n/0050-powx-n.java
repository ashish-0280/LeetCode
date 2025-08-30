class Solution {
    public double myPow(double x, int n) {
        double ans = Math.pow(x, n);
        return ans;
        // long p = Math.abs(n);
        
        // while(p>0){
        //     if(p%2 == 1){
        //         ans = ans*x;
        //         p--;
        //     } else {
        //         x = x*x;
        //         p = p/2;
        //     }
        // }
        // if(n<0){
        //     ans = 1/ans;
        // }
        // return ans;
    }
}