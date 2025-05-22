class Solution {
    public int climbStairs(int n) {
        int n1 = 1; int n2 = 2;
        if(n==1 || n==2){
            return n;
        }
        int cnt = 3;
        while(cnt != n+1){
            int temp = n1+n2;
            n1 = n2;
            n2 = temp; cnt++;
        }
        return n2;
    }
}