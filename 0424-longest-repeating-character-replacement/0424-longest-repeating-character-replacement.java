class Solution {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        int j = 0;
        int maxfreq = 0;
        HashMap <Character, Integer> map = new HashMap<>();
        int i=0;
        while(j<s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
            maxfreq = Math.max(maxfreq, map.get(s.charAt(j)));

            if((j-i+1) - maxfreq > k){
                char left = s.charAt(i);
                map.put(left, map.get(left)-1);
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }
}