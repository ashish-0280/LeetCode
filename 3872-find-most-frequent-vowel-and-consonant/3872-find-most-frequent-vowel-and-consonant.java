class Solution {
    public int maxFreqSum(String s) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                freq1[ch - 'a']++;
            } else {
                freq2[ch-'a']++;
            }
        }
        int max1 = 0; int max2 = 0;
        for(int i=0; i<26; i++){
            max1 = Math.max(max1, freq1[i]);
            max2 = Math.max(max2, freq2[i]);
        }
        return max1 + max2;
    }
}