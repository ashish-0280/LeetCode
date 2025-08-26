class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = 1;
        int i=0; int j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j<s.length()){
            while(map.containsKey(s.charAt(j))){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}