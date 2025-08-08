class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        List<Integer> list = new ArrayList<>();
        for(int i=25; i>=0; i--){
            if(freq[i] != 0){
                list.add(freq[i]);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int change = 0;
        for(int i=0; i<list.size(); i++){
            while(map.containsKey(list.get(i))){
                int temp = list.get(i) - 1;
                list.set(i, temp);
                change++;
            }
            if(list.get(i) != 0){
                map.put(list.get(i), i);
            }
        }
        return change;
    }
}