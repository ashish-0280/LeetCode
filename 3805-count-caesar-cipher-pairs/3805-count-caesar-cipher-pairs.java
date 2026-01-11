class Solution {
    public long countPairs(String[] words) {
        Map<String , Integer> map = new HashMap<>();
        long cnt = 0;
        for(String word: words){
            StringBuilder sb = new StringBuilder();
            int p = word.charAt(0) - 'a';
            for(int i=0; i<word.length(); i++){
                char ch = (char)(((word.charAt(i) - p) + 26 ) % 26);
                sb.append(ch);
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for(int val: map.values()){
            if(val >= 2){
                cnt += (long)(val) * (val-1)/2;
            }
        }
        return cnt;
    }
}