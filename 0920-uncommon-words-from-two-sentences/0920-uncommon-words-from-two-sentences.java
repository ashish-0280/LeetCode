class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap <String, Integer> map = new HashMap<>();
        for(String s: (s1+" "+s2).split(" ")){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        List<String> l = new ArrayList<>();
        for(String s: map.keySet()){
            if(map.get(s) == 1){
                l.add(s);
            }
        }
        return l.toArray(new String[0]);
    }
}