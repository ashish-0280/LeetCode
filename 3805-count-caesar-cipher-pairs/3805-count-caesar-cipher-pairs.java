class Solution {
    public long countPairs(String[] words) {
        Map<String , Integer> map = new HashMap<>();
        long cnt = 0;
        for(int i=0; i<words.length; i++){
            StringBuilder sb = new StringBuilder();
            String s = words[i];
            int p = s.charAt(0) - 'a';
            for(int j=0; j<s.length(); j++){
                char ch = (char)(((s.charAt(j) - p) + 26 ) % 26);
                sb.append(ch);
            }
            String key = sb.toString();
            if(map.containsKey(key)){
                cnt += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return cnt;
    }
}