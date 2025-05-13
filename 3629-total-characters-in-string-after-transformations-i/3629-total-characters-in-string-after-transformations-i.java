class Solution {
    static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        long freq[] = new long[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        while(t>0){
            long temp[] = new long[26];
            for(int i=0; i<26; i++){
                if(i==25){
                    temp[0] = (temp[0] + freq[i]) % MOD;
                    temp[1] = (temp[1] + freq[i]) % MOD;
                } else {
                    temp[i+1] = (temp[i+1] + freq[i]) % MOD;
                }
            }
            freq = temp;
            t--;
        }
        long ans = 0;
        for(long num: freq){
            ans = (ans + num) % MOD;
        }
        return (int)ans;
    }
}