class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        HashMap <Character, Integer> map = new HashMap<>();
        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int i=0; int j=0;
        int countReq = t.length();
        while(j < s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch) > 0){
                    countReq--;
                }
                map.put(ch, map.get(ch)-1);
            }
            while(countReq == 0){
                int currWindowSize = j-i+1;
                if(currWindowSize < minWindowSize){
                    minWindowSize = currWindowSize;
                    start_i = i;
                }
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if(map.get(s.charAt(i)) > 0){
                        countReq++;
                    }
                }
                i++;
            }
            j++;
        }
         return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}