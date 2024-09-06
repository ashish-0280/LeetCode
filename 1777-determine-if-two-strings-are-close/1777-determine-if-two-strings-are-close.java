class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        Set <Character> set1 = new HashSet<>();
        Set <Character> set2 = new HashSet<>();
        HashMap <Character, Integer> map1 = new HashMap<>();
        HashMap <Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<word1.length(); i++){
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0)+1);
            set1.add(word1.charAt(i));
        }
        for(int i=0; i<word2.length(); i++){
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);
            set2.add(word2.charAt(i));
        }
        if(!set1.equals(set2)){
            return false;
        }
        List <Map.Entry<Character, Integer>> list1 = new ArrayList<>(map1.entrySet());
        List <Map.Entry<Character, Integer>> list2 = new ArrayList<>(map2.entrySet());
        Collections.sort(list1, (a, b) -> a.getValue().compareTo(b.getValue()));
        Collections.sort(list2, (a, b) -> a.getValue().compareTo(b.getValue()));
        for(int i=0; i<list1.size(); i++){
            if(!list1.get(i).getValue().equals(list2.get(i).getValue())){
                return false;
            }
        }
        return true;
    }
}