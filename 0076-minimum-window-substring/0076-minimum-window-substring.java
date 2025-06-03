class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(); int m = t.length();
        if(m>n) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int i=0; int j=0;
        int minLength = Integer.MAX_VALUE;
        int count = t.length(); int start_i = i;
        while(j<n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch) > 0) count--;
                map.put(ch, map.get(ch)-1);
            }
            while(count == 0){
                int currSize = j-i+1;
                if(currSize < minLength){
                    minLength = currSize;
                    start_i = i;
                }
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i)) > 0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i+minLength);
    }
}