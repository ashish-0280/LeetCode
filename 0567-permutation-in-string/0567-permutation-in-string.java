class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.contains(s1)) return true;
        int n = s1.length();
        for(int i=0; i<s2.length()-n+1; i++){
            if(check(s1, s2.substring(i, i+n))) return true;
        }
        return false;
    }
    public boolean check(String s1, String s2){
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0; i<s1.length(); i++){
           freq1[s1.charAt(i)-'a']++;
           freq2[s2.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(freq1[i] != freq2[i]) return false;
        } 
        return true;
    }
}