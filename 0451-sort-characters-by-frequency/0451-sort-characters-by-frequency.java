class Solution {
    public String frequencySort(String s) {
       String str = "";
       Map <Character, Integer> map = new TreeMap<>();
       for(int i=0; i<s.length(); i++){
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
       } 
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        for(Map.Entry<Character, Integer> entry: entryList){
            Character c = entry.getKey();
            int n = entry.getValue();
            while(n>0){
                str += c;
                n--;
            }
        }
        return str;
    }
}