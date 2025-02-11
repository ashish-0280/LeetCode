class Solution {
    public int beautySum(String s) {
        int beauty = 0;
        for(int i=0; i<s.length(); i++){
            Map <Character, Integer> map = new HashMap<>();
            TreeMap<Integer, Integer> count = new TreeMap<>();
            for(int j=i; j<s.length(); j++){
                if(map.containsKey(s.charAt(j))){
                    int freq = map.get(s.charAt(j));
                    count.put(freq, count.get(freq)-1);
                    if(count.get(freq) == 0){
                        count.remove(freq);
                    }
                    map.put(s.charAt(j), freq+1);
                } else {
                    map.put(s.charAt(j), 1);
                }
                int newfreq = map.get(s.charAt(j));
                count.put(newfreq, count.getOrDefault(newfreq, 0)+1);
                int min = count.firstKey(); int max = count.lastKey();
                beauty += max-min;
            }
        }
        return beauty;
    }
}