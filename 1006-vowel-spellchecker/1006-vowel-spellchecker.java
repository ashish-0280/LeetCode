class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            String s = wordlist[i];
            String key = s.toLowerCase();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        int i = 0; 
        String[] ans = new String[queries.length];

        for (String query : queries) {
            if (map.containsKey(query.toLowerCase())) {
                List<String> s = map.get(query.toLowerCase());
                if (s.contains(query)) {
                    ans[i] = query; 
                    i++;
                    continue;
                } else {
                    ans[i] = s.get(0); 
                    i++;
                    continue;
                }
            }

            String s1 = query.toLowerCase(); 
            String vowels = "aeiou";
            boolean found = false;

            for (int j = 0; j < wordlist.length; j++) {
                String s2 = wordlist[j].toLowerCase();
                if (s1.length() != s2.length()) continue;

                int p = 0;
                while (p < s2.length()) {
                    char c1 = s1.charAt(p), c2 = s2.charAt(p);
                    if (vowels.indexOf(c1) != -1 && vowels.indexOf(c2) != -1) {
                        p++;
                        continue;
                    }
                    if (c1 != c2) break;
                    p++;
                }

                if (p == s1.length()) {
                    ans[i] = wordlist[j]; 
                    i++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                ans[i] = ""; 
                i++;
            }
        }
        return ans;
    }
}
