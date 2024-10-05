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
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i=0; i<c1.length; i++){
            if(c1[i] != c2[i]) return false;
        }
        return true;
    }
    public String permutations(String s, String s2){
        if(s.length() == 1){
            return s;
        }
        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);
            String remainingString = s.substring(0, i) + s.substring(i+1);
            String t = permutations(remainingString, s2);
            if(s2.contains(t + currentChar)){
                return "ok";
            }
        }
        return "no";
    }
}