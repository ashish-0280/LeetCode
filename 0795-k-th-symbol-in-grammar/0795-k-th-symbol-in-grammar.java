class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 0) return 0;
        int mid = (int)Math.pow(2, n)/2;
        if(k<=mid){
            return kthGrammar(n-1, k);
        }
        return 1-kthGrammar(n-1, k-mid);
    }
}