class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = 1;
        int i=0; int j=0;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length()){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}