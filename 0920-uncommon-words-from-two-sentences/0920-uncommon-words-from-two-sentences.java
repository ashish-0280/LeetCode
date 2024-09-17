class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap <String, Integer> map = new HashMap<>();
        String str = "";
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == ' '){
                map.put(str, map.getOrDefault(str, 0)+1);
                str = "";
            } else {
                str += s1.charAt(i);
            }
        }
        map.put(str, map.getOrDefault(str, 0)+1);
        str = "";
        for(int i=0; i<s2.length(); i++){
            if(s2.charAt(i) == ' '){
                map.put(str, map.getOrDefault(str, 0)+1);
                str = "";
            } else {
                str += s2.charAt(i);
            }
        }
        map.put(str, map.getOrDefault(str, 0)+1);
        List<String> l = new ArrayList<>();
        for(Map.Entry<String, Integer> mapElement : map.entrySet()){
            if(mapElement.getValue() == 1){
                l.add(mapElement.getKey());
            }
        }
        String[] ans = l.toArray(new String[0]);
        return ans;
    }
}