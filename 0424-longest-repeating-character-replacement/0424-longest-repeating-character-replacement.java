class Solution {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        int j = 0;
        int maxfreq = 0;
        HashMap <Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            maxfreq = Math.max(maxfreq, map.get(s.charAt(i)));

            if((i-j+1) - maxfreq > k){
                char left = s.charAt(j);
                map.put(left, map.get(left)-1);
                j++;
            }
            max = Math.max(max, i-j+1);
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }
}