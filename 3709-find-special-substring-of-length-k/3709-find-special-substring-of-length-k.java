class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        HashSet <Integer> set = new HashSet<>();
        int cnt = 1;
        for(int i=1; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i-1);
            if(ch1 == ch2){
                cnt++;
            } else {
                set.add(cnt);
                cnt = 1;
            }
        }
        set.add(cnt);
        return set.contains(k);
    }
}