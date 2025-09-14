class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        for(int i=0; i<wordlist.length; i++){
            String s = wordlist[i].toLowerCase();
            set.add(wordlist[i]);
            map1.putIfAbsent(s, wordlist[i]);
            map2.putIfAbsent(hash(s), wordlist[i]);
        }
        String ans[] = new String[queries.length];
        int i = 0;
        for(String query: queries){
            String s = query.toLowerCase();
            if(set.contains(query)){
                ans[i] = query;
            } else if(map1.containsKey(s)){
                ans[i] = map1.get(s); 
            } else if(map2.containsKey(hash(s))){
                ans[i] = map2.get(hash(s)); 
            } else {
                ans[i] = ""; 
            }
            i++;
        }
        return ans;
    }
    public String hash(String s){
        int p = 0;
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiou";
        while(p < s.length()){
            if(vowels.indexOf(s.charAt(p)) != -1){
                sb.append('#');
            } else {
                sb.append(s.charAt(p));
            }
            p++;
        }
        return sb.toString();
    }
}