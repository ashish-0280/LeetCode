class Solution {
    public long coloredCells(int n) {
        return solve(n, n-1);
    }
    public long solve(int n, int i){
        if(n == 1){
            return 1;
        }
        long l = solve(n-1, i-1);
        return l + 4*(i);
    }
}