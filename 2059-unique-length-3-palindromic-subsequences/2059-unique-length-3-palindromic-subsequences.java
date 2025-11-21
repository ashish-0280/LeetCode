class Solution {
    public int countPalindromicSubsequence(String s) {
        int left[] = new int[26];
        int right[] = new int[26];
        Arrays.fill(left, -1); Arrays.fill(right, -1);
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if(left[idx] == -1) left[idx] = i;
            right[idx] = i;
        }
        int ans = 0;
        for(int i=0; i<26; i++){
            if(left[i] == -1 || left[i] == right[i]) continue;
            boolean mid[] = new boolean[26];
            int p = left[i];
            int q = right[i];
            for(int j=p+1; j<q; j++){
                mid[s.charAt(j) - 'a'] = true;
            }
            for(boolean b: mid){
                if(b) ans++;
            }
        }
        return ans;
    }
}