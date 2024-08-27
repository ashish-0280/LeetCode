class Solution {
    public int tribonacci(int n) {
        if(n<3){
            if(n == 0 || n == 1){
                return n;
            } else if(n == 2){
                return 1;
            }
        }
        int ways[] = new int[n+1];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 1;
        for(int i=3; i<=n; i++){
            // if(ways[i] != 0){
            //     continue;
            // }
            ways[i] = ways[i-3] + ways[i-2] + ways[i-1];
        }
        return ways[n];
    }
}