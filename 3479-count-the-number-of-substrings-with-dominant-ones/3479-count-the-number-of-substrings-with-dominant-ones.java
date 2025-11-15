class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int preIdx[] = new int[n+1];
        for(int i=0; i<n; i++){
            if(i == 0 || s.charAt(i-1) == '0'){
                preIdx[i+1] = i;
            } else {
                preIdx[i+1] = preIdx[i];
            }
        }
        int ans = 0; int cnt = 0;
        for(int r = 1; r <= n; r++){
            int zeroes = s.charAt(r-1) == '0' ? 1 : 0;
            int l = r;
            while(l > 0 && zeroes * zeroes <= n){
                int ones = r - preIdx[l] - zeroes;
                if(ones >= zeroes * zeroes){
                    ans += Math.min(l - preIdx[l], ones - zeroes*zeroes + 1);
                }
                l = preIdx[l];
                zeroes++;
            }
        }
        System.out.println(cnt);
        return ans;
    }
}