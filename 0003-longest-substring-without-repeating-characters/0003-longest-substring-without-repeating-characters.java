class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashSet <Character> set = new HashSet<>();
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        while(i<s.length()){
            int j = i;
            while(j<s.length()){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 0;
                    set.clear();
                    break;
                }
                j++;
            }
            i++;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}