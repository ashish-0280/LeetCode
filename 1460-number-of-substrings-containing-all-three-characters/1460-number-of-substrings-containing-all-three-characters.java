class Solution {
    public int numberOfSubstrings(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('b'); set.add('c');
        int i=0; int j=0;
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.size() == set.size()){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                cnt += s.length()-j;
                i++; 
            }
            j++;
        }
        return cnt;
    }
}