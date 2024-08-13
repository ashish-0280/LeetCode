class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashSet <Character> set = new HashSet<>();
        int p = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                while(p<i && set.contains(s.charAt(i))){
                    set.remove(s.charAt(p));
                    p++;
                }
            }
                set.add(s.charAt(i));
                max = Math.max(max, i-p+1);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}