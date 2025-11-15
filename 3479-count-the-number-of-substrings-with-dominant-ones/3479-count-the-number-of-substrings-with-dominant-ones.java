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
        int ans = 0;
        for(int right = 1; right <= n; right++){
            int zeroes = s.charAt(right-1) == '0' ? 1 : 0;
            int left = right;
            while(left > 0 && zeroes * zeroes <= n){
                int ones = right - preIdx[left] - zeroes;
                if(ones >= zeroes * zeroes){
                    ans += Math.min(left - preIdx[left], ones - zeroes*zeroes + 1);
                }
                left = preIdx[left];
                zeroes++;
            }
        }
        return ans;
    }
}